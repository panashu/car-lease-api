# Maintain the users for the application #

## Quick summary ##

This application implements the APIs needed to read and manage the users for the Car lease API.

The end-users of the Car-lease Platform API are:
Brokers that calculate the leaserate for a customer, and maintain customer data.
Leasing company that maintains data to make a accurate calculation.


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

    server.port= 8081
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

### User Maintenance API ###

On application boot up, details of one broker and one employee are automatically fed by the use of in memory h2 database and by the startup.properties.
http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761