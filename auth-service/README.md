# Gateway microservice using Eureka and Zuul #

## Quick summary ##

this gateway microservice serves as a ZUUL proxy server as well as Eureka server registry.


## How do I get set up? ##

In order to transform a common Spring Boot application into a Zuul proxy Server, only three steps are needed:

* Add Spring Cloud dependency:

    <dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
	</dependency>
    
    <dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
	</dependency>

* Enable Eureka and Netflix Zuul proxy initialization during Spring Boot startup using the annotation `@EnableEurekaServer` and `@EnableZuulProxy` on the main class:

    @SpringBootApplication
    @EnableEurekaServer
    @EnableZuulProxy
    public class AuthServiceApplication {
    ...
    }


*application.properties*

    server.port= 9092
    registerWithEureka= true
    fetchRegistry= true
    defaultZone= http://localhost:8761/eureka/      


### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn clean install` inside the project
* Run `mvn spring-boot:run` inside the project

### Spring Cloud Zuul Proxy Server ###

Zuul Server is a gateway application that handles all the requests and does the dynamic routing of microservice applications. The Zuul Server is also known as Edge Server.

For Example, /car-data-service/api is mapped to the CAR-DATA-SERVICE, AUTH-SERVICE dynamically routes the requests to the respective backend application.

http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761

