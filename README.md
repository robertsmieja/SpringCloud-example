# SpringCloud-example

Requirements
============

* Java 8
* Local MariaDB SQL Server

Optional (for Spring Cloud Tracing)
* Zipkin 
* RabbitMQ Server

## Instructions

* Start up a MariaDB SQL server
** Using Docker: ```docker run --name mariadb-springcloud -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mariadb```

* Start the applications:
```gradlew bootRun```
* Start the Client CLI
```gradlew sc-client:bootRun```

## Development Setup:

### URLs:
```
Database/REST API Server: http://localhost:8080/person/
Eureka Server: http://localhost:8761/
Hystrix Dashboard: http://localhost:8761/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Factuator%2Fhystrix.stream
```
