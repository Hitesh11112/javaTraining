# Employee Spring Boot Application with MySQL

A Spring Boot CRUD REST API with an `Employee` entity containing:

- `id`
- `name`
- `desg`

## Requirements

- Java 17+
- Maven 3.9+
- MySQL 8+

## 1. Configure MySQL

The default configuration is:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```

Change the username and password in:

```text
src/main/resources/application.properties
```

You can also create the database manually:

```sql
CREATE DATABASE employeedb;
```

## 2. Run the application

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

## REST endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Add employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

## Sample POST body

```json
{
  "name": "Swapna",
  "desg": "Trainer"
}
```

The controller permits Angular requests from `http://localhost:4200`.
