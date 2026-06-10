# Functional Requirements

## 1. Authentication

### Student

* Register account
* Login
* Logout

### Teacher

* Login
* Logout

### Admin

* Login
* Logout

---

## 2. User Management

### Admin

Can:

* Create teacher accounts
* View users
* Activate accounts
* Deactivate accounts

---

## 3. Class Management

### Admin

Can:

* Create classes
* Update classes
* Archive classes
* Assign teacher to class

### Teacher

Can:

* View assigned classes

### Student

Can:

* View enrolled classes

---

## 4. Enrollment Management

### Student

Can:

* Request enrollment into class

### Teacher

Can:

* Approve enrollment request
* Reject enrollment request

---

## 5. Attendance Management

### Teacher

Can:

* Record attendance

### Student

Can:

* View attendance records

---

## 6. Grade Management

### Teacher

Can:

* Create grade records
* Update grade records

### Student

Can:

* View own grades

---

# Non-Functional Requirements

* JWT authentication
* Role-based authorization
* Pagination support
* Input validation
* Centralized exception handling
* Logging support
* Redis caching
