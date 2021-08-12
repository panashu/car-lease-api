# Calculate Car Lease Rate #

## Quick summary ##

This application implements the APIs needed to calculate the car lease rate for Car-lease Platform API

Mileage - the amount of kilometers on annual base
Duration - the number of months in the contract
Interest rate with startdate
Nett price

Leaserate is calculated based on the formula : ((( mileage / 12 ) * duration ) / Nett price) + ((( Interest rate / 100 ) * Nett price) / 12 )

Example calculation:
Mileage: 45000 km/yr
Duration: 60 months
Interest rate: 4.5%
Nett Price: € 63000
Leaserate: € 239,76 per month // MvdS: Als ik dit uitreken kom ik op: 239,82 (misschien moeten we iets zeggen
over decimalen achter de komma?)



## How do I get set up? ##


* Add Spring boot and h2 in memory dependencies:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
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
    public class LeaseRateServiceApplication {
    ...
    }

*application.properties*

    server.port= 8084
    registerWithEureka= true
    fetchRegistry= true
    defaultZone= http://localhost:8761/eureka/
    
### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn clean install` inside the project
* Run `mvn spring-boot:run` inside the project

### Lease rate Calculation API ###

/lease-rate-service/api is mapped to the LEASE-RATE-SERVICE, AUTH-SERVICE dynamically routes the requests to the respective backend application.

http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761