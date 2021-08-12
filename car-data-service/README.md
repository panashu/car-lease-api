# Maintain Car Attributes #

## Quick summary ##

This application implements the APIs needed to view and manage the attributes of Car details for Car-lease Platform API

This API can maintain (read, add, change and delete) basic car attributes:
Make
Model
Version
Number of doors
CO2-emission
Gross price
Nett price


## How do I get set up? ##

This is a Spring Boot application which works with in memory database to meet the above functional requirements. Data is loaded during the application boot up and lost when the application is stopped.

* Add Spring boot and h2 in memory dependencies:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>runtime</scope>
	</dependency>
	
* Add Netflix Eureka Client and Hystrix dependencies:

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>	
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>

* Enable Spring Boot, Netflix Eureka Client, Hystrix startup using the annotation `@SpringBootApplication` , `@EnableEurekaClient` and `@EnableHystrix`  on the main class:

    @SpringBootApplication 
    @EnableEurekaClient 
    @EnableCircuitBreaker 
    @EnableHystrixDashboard 
    @EnableHystrix
    public class CarDataServiceApplication {
    ...
    }

*application.properties*

    server.port= 8083
    registerWithEureka= true
    fetchRegistry= true
    defaultZone= http://localhost:8761/eureka/
    
    spring.datasource.url=jdbc:h2:mem:cardb
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.initialization-mode=always
    
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    
    spring.h2.console.enabled=true

### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn clean install` inside the project
* Run `mvn spring-boot:run` inside the project

### Car Maintenance API ###

/car-data-service/api is mapped to the CAR-DATA-SERVICE, AUTH-SERVICE dynamically routes the requests to the respective backend application.

http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761