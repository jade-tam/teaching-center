Start by defining REST endpoints.

```
POST   /api/auth/register
POST   /api/auth/login
POST   /api/auth/logout
```

Admin:

```
GET    /api/admin/users
POST   /api/admin/teachers
PATCH  /api/admin/users/{id}/status

POST   /api/admin/classes
PUT    /api/admin/classes/{id}

POST   /api/admin/classes/{id}/assign-teacher
```

Teacher:

```
GET    /api/teacher/classes

GET    /api/teacher/enrollment-requests

POST   /api/teacher/enrollment-requests/{id}/approve
POST   /api/teacher/enrollment-requests/{id}/reject

POST   /api/teacher/attendance

POST   /api/teacher/grades
PUT    /api/teacher/grades/{id}
```

Student:

```
GET    /api/student/classes

POST   /api/student/enrollment-requests

GET    /api/student/grades

GET    /api/student/attendance
```
