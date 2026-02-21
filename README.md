## Employee Activity Tracker (DAR System)

### Overview
Many companies require employees to submit Daily Activity Reports (DARs), but these are often scattered across folders, making tracking and accountability inefficient. This system centralizes all employee DARs into a single platform for structured access and oversight.

### Core Functionality
Employees:
- Create, update, and view their own daily activity reports
- Access previous reports

Supervisors:
- View all employee DARs
- Monitor live activity for current shifts
- Review past reports for accountability and tracking

### Architecture
Backend:
- Spring Boot REST API handling business logic and data flow

Database (planned):
- PostgreSQL for storing employees, supervisors, and DARs

Frontend (planned):
- Calendar-based dashboard for supervisors to view employee activity by shift/date
- Role-based views for employees and supervisors

### Purpose
Improve visibility into employee work, eliminate disorganized report storage, and enable supervisors to track performance in real time and historically.

### Status
Early development (backend in progress)