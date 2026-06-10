# Teaching Center Management System

A web-based management system for a programming teaching center.

## Overview

The system allows administrators, teachers, and students to manage teaching activities, class enrollment, attendance, and grades.

### Roles

* Admin
* Teacher
* Student

### Features

#### Authentication

* Student registration
* Login
* Logout
* JWT authentication
* Role-based authorization

#### User Management

* Admin creates teacher accounts
* Admin manages users
* Account activation/deactivation

#### Class Management

* Admin creates classes
* Admin assigns teachers to classes
* Teachers manage students in their classes

#### Enrollment

* Students request enrollment into classes
* Teachers approve or reject enrollment requests

#### Attendance

* Teachers record attendance
* Students view attendance history

#### Grades

* Teachers record grades
* Students view grades

## Technology Stack

### Frontend

* Next.js
* TypeScript
* Tailwind CSS

### Backend

* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* Redis
* Flyway

### Infrastructure

* Docker
* Docker Compose

## Project Structure

teaching-center/

* frontend/
* backend/
* docs/

## Future Enhancements

* Email notifications
* Assignment management
* Course materials
* Reports and analytics
* Audit logging
