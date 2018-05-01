# SpringCloud-example

Requirements
============

* Java 8
* Local MySQL Server

## Instructions

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
