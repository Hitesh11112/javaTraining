# Employee–Department Microservices

A 4-service microservices system built with Spring Boot + Spring Cloud, demonstrating service discovery, inter-service communication with Feign, an API Gateway, and container/orchestration deployment (Docker Compose + Kubernetes).

## Architecture

```
                        ┌─────────────────┐
                        │   API Gateway   │  (port 8081)
                        │  (Spring Cloud  │
                        │     Gateway)    │
                        └────────┬────────┘
                                 │ routes by path
                 ┌───────────────┴───────────────┐
                 ▼                                ▼
      ┌────────────────────┐          ┌────────────────────┐
      │ department-service │  Feign   │  employee-service   │
      │     (port 8083)    │ ───────► │     (port 8082)     │
      └──────────┬─────────┘          └──────────┬──────────┘
                 │                                │
                 ▼                                ▼
          departmentdb (MySQL)              employeedb (MySQL)

      Both services register with, and discover each other through:
                        ┌─────────────────┐
                        │  Eureka Server  │  (port 8761)
                        └─────────────────┘
```

- **Eureka Server** — service registry. Every other service registers itself here on startup, and looks up other services' locations here instead of hardcoding hostnames/ports.
- **API Gateway** — single public entry point. Routes `/api/departments/**` → `department-service`, `/api/employees/**` → `employee-service`, using Eureka to find them (`lb://department-service` means "load-balance across instances registered as department-service").
- **department-service** — calls `employee-service` via a **Feign client** (`EmployeeClient`) to fetch employees belonging to a department, with a **fallback** (`EmployeeClientFallback`) that returns an empty list if employee-service is down — this is a basic circuit-breaker pattern.
- **employee-service** — owns employee data, exposes a `/department/{did}` endpoint that department-service's Feign client calls into.

---

## Prerequisites

- Java 17
- Maven
- MySQL running locally (only needed for the "run locally" path below — Docker/Kubernetes paths run their own MySQL container)
  - Default expected username/password: `root` / `root` — update `application.properties` in each service if yours differs
- Docker + Docker Compose (only for the Docker path)
- A running Kubernetes cluster, e.g. Minikube (only for the Kubernetes path)

---

## Option 1 — Run everything locally with Maven (no Docker)

Startup **order matters** here — Eureka first, everything else after, since employee-service and department-service both try to register with Eureka on boot.

### Step 1 — Start Eureka Server
```bash
cd EurekaServer
mvn spring-boot:run
```
Runs on **port 8761**. Visit `http://localhost:8761` — you should see the Eureka dashboard, empty of instances at this point.

### Step 2 — Start employee-service
```bash
cd employee-service
mvn spring-boot:run
```
Runs on **port 8082**. Auto-creates the `employeedb` MySQL schema (`createDatabaseIfNotExist=true`) using whatever credentials are in `employee-service/src/main/resources/application.properties`.

### Step 3 — Start department-service
```bash
cd department-service
mvn spring-boot:run
```
Runs on **port 8083**. Same idea — auto-creates `departmentdb`.

### Step 4 — Start API Gateway
```bash
cd ApiGateway
mvn spring-boot:run
```
Runs on **port 8081** — this is the one public port you'll actually call from Postman/browser once everything's up.

### Step 5 — Verify registration
Refresh `http://localhost:8761` — you should now see `DEPARTMENT-SERVICE`, `EMPLOYEE-SERVICE`, and `APIGATEWAY` listed as registered instances.

---

## API Endpoints (call these through the Gateway, port 8081)

### Employee endpoints
| Method | URL |
|---|---|
| POST | `/api/employees` |
| GET | `/api/employees` |
| GET | `/api/employees/{eid}` |
| PUT | `/api/employees/{eid}` |
| DELETE | `/api/employees/{eid}` |
| GET | `/api/employees/department/{did}` — used internally by department-service's Feign client, but callable directly too |

**Example employee request body:**
```json
{
  "ename": "Swapna",
  "salary": 55000,
  "mobile": "9876543210",
  "email": "swapna@example.com"
}
```

### Department endpoints
| Method | URL |
|---|---|
| POST | `/api/departments` |
| GET | `/api/departments` |
| GET | `/api/departments/{did}` — returns the department **plus its employees**, fetched live via Feign from employee-service |
| PUT | `/api/departments/{did}` |
| DELETE | `/api/departments/{did}` |

**Example department request body:**
```json
{
  "dname": "Information Technology",
  "location": "Hyderabad"
}
```

**Try the cross-service call:** create a department, create an employee with that department's id, then `GET /api/departments/{did}` — you should see the employee list embedded in the response, proving the Feign call to employee-service worked.

**Try the fallback:** stop employee-service, then `GET /api/departments/{did}` again — instead of an error, you should get the department with an **empty** employee list, and `"Employee Service is down"` printed in department-service's console. This demonstrates the fallback pattern.

---

## Option 2 — Run everything with Docker Compose

This spins up MySQL + all 4 services in containers, fully networked together — no local MySQL or manual startup ordering needed.

### Step 1 — Build each service's jar/war first
Docker Compose expects a `target/*.jar` (or `.war` for Eureka) to already exist, since each `Dockerfile` just copies it in — it doesn't run Maven itself. Build all four:
```bash
cd EurekaServer && mvn clean package -DskipTests && cd ..
cd ApiGateway && mvn clean package -DskipTests && cd ..
cd employee-service && mvn clean package -DskipTests && cd ..
cd department-service && mvn clean package -DskipTests && cd ..
```

### Step 2 — Bring everything up
```bash
docker-compose up --build
```

This starts, in dependency order (via `depends_on`):
1. `mysql-db` — waits for a healthcheck (`mysqladmin ping`) before anything else proceeds
2. `eureka-server` — starts once MySQL is healthy
3. `department-service` + `employee-service` — wait for both MySQL (healthy) and Eureka (started)
4. `api-gateway` — waits for Eureka + both services to start

### Step 3 — Access it
Same as before — API Gateway is exposed on **port 8081** on your host machine. Eureka dashboard is on **port 8761**.

### Note on the Docker MySQL credentials
Inside `docker-compose.yml`, MySQL's root password is `root`, and the database names are `department_db`/`employee_db` (with underscores) — these are injected into each service container via environment variables (`SPRING_DATASOURCE_URL`, etc.), overriding whatever is in `application.properties`. You don't need to edit any file for the Docker path.

### Stopping everything
```bash
docker-compose down
```
Add `-v` (`docker-compose down -v`) if you also want to wipe the MySQL data volume and start fresh next time.

---

## Option 3 — Deploy to Kubernetes

The `kubernetes/` folder has one YAML per component, all scoped to a dedicated `microservices` namespace.

### Step 1 — Create the namespace first
```bash
kubectl apply -f kubernetes/namespace.yml
```
Every other manifest references `namespace: microservices`, so this must exist before anything else is applied.

### Step 2 — Apply MySQL (includes a PersistentVolumeClaim, so data survives pod restarts)
```bash
kubectl apply -f kubernetes/mysql.yml
```

### Step 3 — Apply Eureka
```bash
kubectl apply -f kubernetes/eureka.yml
```

### Step 4 — Apply both business services
```bash
kubectl apply -f kubernetes/employees.yml
kubectl apply -f kubernetes/department.yml
```

### Step 5 — Apply the API Gateway last
```bash
kubectl apply -f kubernetes/api-gateway.yml
```

### Step 6 — Check everything's running
```bash
kubectl get pods -n microservices
kubectl get svc -n microservices
```

### Step 7 — Access the Gateway
Depending on how `api-gateway.yml` exposes its Service (`NodePort`/`LoadBalancer`), either:
```bash
minikube service api-gateway -n microservices
```
or port-forward manually:
```bash
kubectl port-forward svc/api-gateway 8081:8081 -n microservices
```

---

## Troubleshooting

| Symptom | Likely cause |
|---|---|
| A service won't register with Eureka | Check `eureka.client.service-url.defaultZone` in that service's `application.properties` — for Docker/Kubernetes it must point to the container/service name (`http://eureka-server:8761/eureka`), not `localhost` |
| Gateway returns 404 for a valid path | Check the `spring.cloud.gateway...routes[].predicates` in `ApiGateway/application.properties` match the path you're calling, and that the target service is actually registered (check the Eureka dashboard) |
| Department's employee list is always empty | employee-service isn't running/registered — this is the Feign fallback kicking in intentionally, not a bug |
| MySQL connection refused (local run) | Update `spring.datasource.username`/`password` in each service's `application.properties` to match your actual local MySQL credentials |
| Docker Compose services keep restarting | Check `docker-compose logs <service-name>` — commonly means the jar wasn't rebuilt after a code change (rerun Step 1 of Option 2) |
