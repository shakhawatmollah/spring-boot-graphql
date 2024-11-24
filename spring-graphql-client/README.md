# Client: Spring Boot with GraphQL

This project is a demonstration of a modern Spring Boot application utilizing:
- **Spring Boot 3.4** for application configuration and management.
- **GraphQL** for querying and mutating data.

## Features

- GraphQL endpoints for consuming and mutating data via HTTP requests.
- Support for GraphQL queries and mutations.
- Record and playback of GraphQL queries and mutations.
- TextBlocks for GraphQL queries and mutations.

---

## Getting Started

### Prerequisites

- **Java 17** or higher.
- **Maven 3.8+** for building the project.
- **Git** for version control.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/shakhawatmollah/spring-boot-graphql.git
    ```
2. Navigate to the project directory:
    ```bash
    cd spring-graphql-client
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
    - http://localhost:8888/api/catalog/*

### Postman Collection

1. Open Postman.
2. Import the `spring-graphql.postman_collection.json` file into Postman.
3. Run the collection.

## Contributing

We welcome contributions to this project. Here are the steps to contribute:

1. Fork the repository.
2. Create a new branch.
3. Commit your changes.
4. Create a pull request.
5. Review and approve the pull request.
