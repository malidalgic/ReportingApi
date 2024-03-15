# Reporting API

## Project Description
The Reporting API is a RESTful API developed using Java and Spring Boot, focusing on data reporting and processing capabilities with a secure token-based authentication system.

## Key Technical Information
- **Java Version**: Java SE Development Kit 8u202
- **Spring Boot**: 2.5.0
- **Database**: H2 (managed with Liquibase)
- **Frontend**: Simple AJAX calls included in HTML pages (login.html and main.html)


## API Usage
The API includes 5 main endpoints and requires a user-generated token for secure access. The token has a 10-minute validity period.

## Postman Collection
To explore and test the API endpoints, you can use the Postman collection available at:
[Reporting API Postman Collection](https://www.postman.com/malidalgic/workspace/reporting-api/collection/22785614-987187aa-a75c-4743-8a21-b5950534db79?action=share&creator=22785614)


## Developer Information
- **Developer**: Mehmet Ali DALGIÇ
- **Contact**: [malidalgic51@gmail.com](mailto:malidalgic51@gmail.com)

## Technical Features and Tools
- Token-based authentication system
- Interactive frontend pages with AJAX
- Database management with Liquibase

## Tests
The project is secured with unit tests. These tests are written extensively to ensure the robustness and adherence to expectations.

## Error Handling
The project effectively manages error situations with custom exception handlers. It provides user-friendly error messages, simplifying the API usage.

