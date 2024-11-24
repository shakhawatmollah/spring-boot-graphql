# Server: Spring Boot with GraphQL, JPA and MySQL

This project is a demonstration of a modern Spring Boot application utilizing:
- **Spring Boot 3.4** for application configuration and management.
- **JPA (Java Persistence API)** for database interaction.
- **GraphQL** for API design and querying.
- **MySQL** as the relational database.

## Features

- GraphQL endpoints for CRUD operations.
- MySQL database integration with JPA for seamless data persistence.
- Configurable application properties for environment-specific settings.
- Clean and extensible architecture with reusable service and repository layers.

---

## Getting Started

### Prerequisites

- **Java 17** or higher.
- **Maven 3.8+** for building the project.
- **MySQL Server** installed and running.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/shakhawatmollah/spring-boot-graphql.git
    ```
2. Navigate to the project directory:
    ```bash
    cd spring-graphql-server
    ```
## Running the Application

1. Build the project:
   ```bash
   mvn clean install
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Access the application:
    - GraphQL Playground: `http://localhost:8080/product-service/graphiql`

---

## GraphQL Usage

### Example Query
```graphql
query MyQuery {
  getProducts {
    category
    name
    price
    stock
  }
}
```

### Example Mutation
```graphql
mutation MyMutation {
   saveProduct(category: "IT", name: "Mouse", price: 15, stock: 100) {
      name
      price
   }
}
```

---

## Dependencies

### Core Dependencies
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-graphql`
- `mysql-connector-java`

### Additional Dependencies
- `spring-boot-starter-web`
- `lombok` (for reducing boilerplate code)
- `spring-boot-starter-test`

---