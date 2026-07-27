# Employee Service and Department Service

## Requirements
- Java 17
- Maven
- MySQL
- MySQL username/password used in both projects: `root` / `root`

Update `application.properties` when your MySQL credentials differ.

## Run Employee Service
```bash
cd employee-service
mvn spring-boot:run
```
Runs on port `8081`.

### Employee endpoints
- POST `/api/employees`
- GET `/api/employees`
- GET `/api/employees/{eid}`
- PUT `/api/employees/{eid}`
- DELETE `/api/employees/{eid}`

### Employee request
```json
{
  "ename": "Swapna",
  "salary": 55000,
  "mobile": "9876543210",
  "email": "swapna@example.com"
}
```

## Run Department Service
```bash
cd department-service
mvn spring-boot:run
```
Runs on port `8082`.

### Department endpoints
- POST `/api/departments`
- GET `/api/departments`
- GET `/api/departments/{did}`
- PUT `/api/departments/{did}`
- DELETE `/api/departments/{did}`

### Department request
```json
{
  "dname": "Information Technology",
  "location": "Hyderabad"
}
```
