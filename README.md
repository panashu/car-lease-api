# All microservices in an overview #

## Quick summary ##

The Car-lease Platform API is a REST API that allows to maintain vehicle versions, customers and other data needed to
service a broker.

## Overview of micro services ##

* (1) Create a Eureka server (eureka-server)
* (2) Create a gateway using spring-boot microservice. Add ZUUL, Eureka client dependency to it. So gateway will act as ZUUL proxy server. (auth-service)
* (3) Create one microservice with Eureka client dependency and register them in Eureka server and add Spring security dependency. (appuser-service: responsible for user CRUD)
* (4) Create another microservice responsible for login (login-service)
* (5) Create another microservice responsible for car data management (car-data-service)
* (6) Create another microservice responsible for customer info management (customer-info-service)
* (7) Create another microservice responsible for calculation of lease rate (lease-rate-service)