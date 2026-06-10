# System Architecture

## Frontend

Next.js application

Responsibilities:

* Authentication UI
* Class management UI
* Attendance UI
* Grade UI

---

## Backend

Spring Boot REST API

Responsibilities:

* Authentication
* Authorization
* Business logic
* Data validation

---

## PostgreSQL

Persistent data storage

Stores:

* Users
* Classes
* Enrollments
* Attendance
* Grades

---

## Redis

Stores:

* Refresh tokens
* Cached data

---

## Security

* Spring Security
* JWT Access Token
* Refresh Token
* Role-Based Access Control

---

## Logging

Application Logs:

* Login events
* Enrollment events
* Grade updates

Audit Logs:

* Teacher actions
* Admin actions
