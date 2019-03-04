# University SPA

## Build Setup

## Requirements

For building and running the application you need is:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

#### Configure database connection
Specify properties for your PostgreSQL database at application.properties:
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password

#### Run the application
``` bash
mvn spring-boot:run
```
App is running on [http:localhost:8085/](http:localhost:8085/)

To login perform post request on [http:localhost:8085/login](http:localhost:8085/login)
User credentials:
- email: admin
- password: admin

#### Open Swagger UI

Swagger UI is running on [http:localhost:8085/swagger-ui.html](http:localhost:8085/swagger-ui.html)

To authorize your requests add value 'Bearer TOKEN_RECEIVED_AFTER_LOGIN' to authorizations.

#### Requirements for running Selenium tests

- Download [chromedriver](http://chromedriver.chromium.org/)
- Download Selenium standalone server [selenium-server-standalone-2.53.1.jar](http://selenium-release.storage.googleapis.com/index.html?path=2.53/) 

Run selenium from a command prompt:
``` bash
java -jar selenium-server-standalone-2.53.1.jar -port 4445
```
Run your application
``` bash
mvn spring-boot:run
```
Run tests
``` bash
mvn test
```
You'll see your test start Chrome after a while