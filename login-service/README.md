# Login Service for Car Lease API #

## Quick summary ##

This application implements the APIs needed to provide an entrypoint to login for Car-lease Platform API

This API takes in username and password of the employee and does the authentication in the background.


## How do I get set up? ##


* Add Spring boot and jwt dependencies:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
		<groupId>io.jsonwebtoken</groupId>
		<artifactId>jjwt</artifactId>
		<version>0.9.0</version>
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

* Enable Spring Boot, Netflix Eureka Client `@SpringBootApplication` and `@EnableEurekaClient` on the main class:

    @SpringBootApplication 
    @EnableEurekaClient 
    public class LoginServiceApplication {
    ...
    }

*application.properties*

    server.port= 9090
    registerWithEureka= true
    fetchRegistry= true
    defaultZone= http://localhost:8761/eureka/
    
### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn clean install` inside the project
* Run `mvn spring-boot:run` inside the project

### Login Maintenance API ###

/login-service/api is mapped to the LOGIN-SERVICE, AUTH-SERVICE dynamically routes the requests to the respective backend application.

http://localhost:8761/ in your web browser and you can find the Eureka Server running on the port 8761

### How authentication and authoriation using jwt and oauth token is implemented ###

Signin request accepts username and password. If username and password are valid it will generate a jwt token and sent back the token in the response header.
All other request headers should contain the JWT token which we have generated from signin service, it will be validated. If validation fails an exception will be thrown from filter service.
Request with valid JWT token will be processed.
Request header should contain Authorization : valid-jwt-token key value pairs

