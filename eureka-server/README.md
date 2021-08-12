# Service Discovery using Eureka #

## Quick summary ##

This application implements a Service Discovery pattern using Netflix server implementation: [Euraka] (https://github.com/Netflix/eureka).

Instead of using Eureka project on its own, this application uses Spring ecosystem to integrate it into the application.

It uses [Spring Boot](http://projects.spring.io/spring-boot/) to start Spring context and run the application and [Spring Cloud Eureka](https://cloud.spring.io/spring-cloud-netflix/) to integrate Netflix implementation into Spring.


## How do I get set up? ##

In order to transform a common Spring Boot application into an Eureka Server, only three steps are needed:

* Add Spring Cloud dependency:

    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-eureka-server</artifactId>
    </dependency>

* Enable Eureka initialization during Spring Boot startup using the annotation `@EnableEurekaServer` on the main class:

    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaServerApplication {
    ...
    }


*application.properties*

    server.port= 8761
    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
      
This is the Eureka server application and it is a spring cloud managed service. Therefore it has the similar nature as other microservices.

In microservice architecture, every microservice(spring cloud service) should be registered themselves with Eureka server to make them discoverable (through Eureka server). 
Since this is the Eureka server, it does not need to be registered. Otherwise the Eureka server will register with itself.
On the other hand, Eureka server does not need to fetch the information of the registered services from itself (from the registry available on itself). So we have disable that feature too.

### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn clean install` inside the project
* Run `mvn spring-boot:run` inside the project

### Eureka Spring Server ###

The Eureka server can be reached at http://localhost:8761

When only this microservice is deployed, no instances of the Eureka client (other microservices) will be available.
Which means service registry is fine and it is looking for the Eureka client to register. 

When the other microservices are registered, these instances will be available under this gateway service.

