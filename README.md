Hotel Management System

The Hotel Management System is designed to streamline operations for both hotel employees and guests. It offers functionalities for customers to search available rooms, make reservations, check-in, check-out, and generate invoices. Employees can manage room availability, maintain customer profiles, oversee housekeeping schedules, and manage billing. The system uses Spring Boot to provide a set of RESTful APIs to support web and mobile interfaces.

Resources:

Customer Management

Register: Allows new users to register.

Login: Authenticates users and provides a JWT for secure access.

Profile Management: Enables users to view and update their profiles and change passwords.

Employee Management:

Admin Functions: Admins can manage hotel employees and staff.

Search Functionality

Reservations: Search for reservations by customer name, ID, and date.

Customer Info: Search for customer information.

Room Availability: Check room availability with details like price, facilities, capacity, size, and features.

Reservation Management

Booking: Allows customers to book rooms.

Modification and Cancellation: Customers can modify and request cancellations (admin approval required).

Room Management:

Room Types and Status: Admins can manage room types, availability, and status.

Check-In/Check-Out

Customer Management: Admins manage the arrival and departure processes.

Housekeeping Management:

Scheduling and Tracking: Manage housekeeping tasks and schedules.

Billing Functionality:

Invoice Management: Generate and manage invoices for customer reservations.

Class Diadram: 
![image](https://github.com/saeedmosaffer/project2-hotel-management-system/assets/132621749/dd25b4c4-b326-4d40-be23-35edc6f69e52)

ER Diagram:
![image](https://github.com/saeedmosaffer/project2-hotel-management-system/assets/132621749/b7c13ad9-12aa-4866-9346-0a2610d38519)


How to Build, Package, and Run the Application:

Prerequisites

Java 11 or higher

Maven 3.6+

Docker (for building Docker images)

Building the Application

1. Clone the repository:

git clone https://github.com/saeedmosaffer/project2-hotel-management-system.git

cd hotel-management-system

2. Build with Maven:

mvn clean install

3. Run the Application:
   
java -jar target/project2-hotel-management-system-0.0.1-SNAPSHOT.jar

Docker Image:

Build Docker Image: docker build -t saeedmosaffer/project2-hotel-management-system

Run Docker Container: docker run -p 8080:8080 saeedmosaffer/project2-hotel-management-system

DockerHub Repository: 

What I Learned:

Spring Boot: Understanding the fundamentals of Spring Boot for building RESTful APIs.

JWT Authentication: Implementing JWT for secure API access.

API Versioning: Utilizing different strategies for API versioning (URI, Request Parameter, Accept Header).

Database Management: Designing and implementing entity relationships using JPA.

Docker: Containerizing the application for consistent deployment.

Exception Handling and Validation: Ensuring robust API responses and input validation.

OAS 3.1.0: Documenting APIs using OpenAPI Specification for clarity and maintainability.

Role-Based Access Control: Differentiating access levels for admin and customer roles.


Contributor:
Saeed Mosaffer - 1202254
