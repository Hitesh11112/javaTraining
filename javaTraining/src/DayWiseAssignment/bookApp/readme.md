# Day_16_07_26_springboot — bookApp

A Spring Boot REST API for managing books (CRUD), backed by MySQL, containerized with Docker, deployed to Kubernetes (Minikube), and automated end-to-end with a Jenkins CI/CD pipeline.

## Tech Stack

- **Java 17**, Spring Boot (Web MVC, Data JPA, Validation)
- **MySQL 8.0** (database: `bookDB`)
- **Lombok**
- **Docker** (multi-stage build, `eclipse-temurin` JDK/JRE)
- **Kubernetes** (Minikube) — MySQL + Book service deployments
- **Jenkins** — CI/CD pipeline (Windows agent, `bat` steps)
- Packaged as a **WAR**, runs on port `8085`

## Project Structure

```
Day_16_07_26_springboot/
├── src/main/java/com/coforge/
│   ├── Day160726SpringbootApplication.java
│   ├── controller/BookController.java
│   ├── service/BookService.java
│   ├── dao/BookDao.java
│   ├── repositories/BookRepository.java
│   ├── entities/Book.java
│   └── exceptions/
│       ├── BookNotFoundException.java
│       └── GlobalExceptionHandler.java
├── src/main/resources/
│   └── application.yml
├── k8s/
│   ├── book.yml        # Book service Deployment + Service (NodePort 30085)
│   └── mysql.yml       # MySQL Deployment + Service (ClusterIP)
├── Dockerfile
├── Jenkinsfile
└── pom.xml
```

## API Endpoints

| Method | Endpoint                   | Description                  |
|--------|-----------------------------|-------------------------------|
| GET    | `/books`                    | Get all books                |
| POST   | `/books`                    | Add a new book                |
| GET    | `/books/{id}`                | Get a book by ID              |
| PATCH  | `/books/{id}`                | Update a book by ID           |
| DELETE | `/books/{id}`                | Delete a book by ID           |
| GET    | `/books/author/{author}`     | Get books by author           |
| GET    | `/books/title/{title}`       | Get a book by title           |

### Book fields & validation

| Field          | Validation                                              |
|----------------|-----------------------------------------------------------|
| `title`        | Not blank, minimum 3 characters                          |
| `author`       | Not blank                                                 |
| `authorMobile` | Must match `^[6-9][0-9]{9}$` (10 digits, starts 6–9)     |
| `email`        | Must be a valid email format                             |
| `price`        | Minimum value 100                                        |

## Running Locally

### Prerequisites
- JDK 17
- MySQL running locally on port `3306` with a database named `bookDB`

### Steps
```bash
./mvnw clean package -DskipTests
java -jar target/springbootapp.war
```
App runs at `http://localhost:8085`.

Default datasource config (`application.yml`):
```yaml
spring:
  datasource:
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/bookDB
    username: root
    password: hitesh@123
```

## Running with Docker

```bash
docker build -t hiteshpatwal/spring-boot-bookapp:latest .
docker run -p 8085:8085 hiteshpatwal/spring-boot-bookapp:latest
```

## Deploying to Kubernetes (Minikube)

```bash
kubectl apply -f k8s/mysql.yml
kubectl rollout status deployment/mysql-deployment

kubectl apply -f k8s/book.yml
kubectl rollout status deployment/book-deployment
```

The book service is exposed via **NodePort 30085**:
```bash
minikube service book-service --url
```

## CI/CD — Jenkins Pipeline

The `Jenkinsfile` defines a pipeline that runs on a **native Windows Jenkins agent** (not Dockerized), polling GitHub hourly (`pollSCM('H H * * *')`) since GitHub can't reach `localhost` directly.

**Stages:**
1. **Checkout** — pulls from GitHub
2. **Build Spring Boot** — `mvnw.cmd clean package -DskipTests`
3. **Build Docker Image** — tags with both `BUILD_NUMBER` and `latest`
4. **Push to Docker Hub** — using Jenkins credential `dockerhub-creds`
5. **Deploy MySQL** — `kubectl apply -f k8s/mysql.yml` + rollout check
6. **Deploy Book Application** — `kubectl apply -f k8s/book.yml`, updates image via `kubectl set image`, then verifies rollout
7. **Verify Deployment** — prints nodes, deployments, pods, services

Each stage explicitly checks `%ERRORLEVEL%` so a failure anywhere stops the build instead of reporting a false success.

## Notes

- Uses `application.yml` (converted from `application.properties`) for configuration.
- `MYSQL_HOST` defaults to `localhost` locally, and is set to `mysql-service` in Kubernetes for in-cluster DNS resolution.
- Docker image: [`hiteshpatwal/spring-boot-bookapp`](https://hub.docker.com/r/hiteshpatwal/spring-boot-bookapp)
