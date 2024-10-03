# Event Ticketing Back-end Application (REST API)

Copied from my current Software Product Management [CO3013] project.

## Prerequisites

* [Java JDK 21] (https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
* [Gradle] (https://gradle.org/install/)

## Build the project
- Clone the project
- Run 
```bash
gradle build
```

## Application properties
- Configure your application properties in the `src/main/resources/application.properties` file. Example configurations include:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:postgresql//localhost:5432/spring demo
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

- Make sure to set up your database (e.g., MySQL) and adjust the database configuration in `application.properties` as needed.
- If there isn't any change to any Model, change `spring.jpa.hibernate.ddl-auto` property to `update` to avoid dropping the database each time you start the application.

## Run the project
Run the application with:
```bash
gradle bootRun
```
Alternatively, after building the project, you can also run the JAR file directly:
```bash
java -jar target/<project-name>.jar
```

## Accessing the Application
Once the application is running, you can access it at:
```
http://localhost:8080
```
