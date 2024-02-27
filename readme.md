
# Hiperboot Example

## Overview
Hiperboot is a versatile library designed to simplify executing queries in Hibernate, compatible with various SQL databases. This example application demonstrates the use of Hiperboot for retrieving lists or pages of data filtered and sorted according to specified criteria using Spring Data.

## Installation
1. Clone the Hiperboot example repository:
   ```bash
   git clone https://github.com/sannonaragao/hiperboot-service-example
   ```
2. Navigate to the project directory and build the project:
   ```bash
   gradle clean build
   ```

## Running the Application

- Start the server:
  ```bash
  gradle bootRun
  ```
- Access the Swagger UI at: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Usage

### Endpoints
- **Paginated Books** (`/books-paginated`):
    - Retrieves books with pagination.
    - Curl Example:
      ```bash
      curl -X 'POST' \
      'http://localhost:8080/books-paginated' \
      -H 'accept: */*' \
      -H 'Content-Type: application/json' \
      -d '{ "author": { "id": 2 }, "price":{ "from": "12" }, "_page": { "offset": 0, "limit": 5, "sort": "-title" } }'
      ```

- **Books List** (`/books-list`):
    - Retrieves a list of all books without pagination.
    - Curl Example:
      ```bash
      curl -X 'POST' \
      'http://localhost:8080/books-list' \
      -H 'accept: */*' \
      -H 'Content-Type: application/json' \
      -d '{ "author": { "id": 2 }, "price":{ "from": "12" }}'
      ```

## Support and Documentation
For more details on the main Hiperboot project, or just to leave a star/thumbs up, please visit:
- [Hiperboot GitHub](https://github.com/sannonaragao/hiperboot)
- [Developer's GitHub](https://github.com/sannonaragao/)
- [Developer's LinkedIn](https://www.linkedin.com/in/sannonaragao/)

---
