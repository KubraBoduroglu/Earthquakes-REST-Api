# Earthquakes Service Application

---
### The service provides an API
#### `Earthquakes-REST-Api`
* To to get earthquakes data from international sources.

### How does the application works?
* Application receives the requested via 
	* `/UsgsClient/getCountObject`  
	* `/UsgsClient/getCountEntity`  
	* `/UsgsClient/getCountWithWebClient`  
	* `/UsgsClient/getUsgsData/v1`  
	* `/UsgsClient/getUsgsData/v2`  

* On the swagger page you can find the relevant api endpoint. 
You can reach the OpenApi page by `http://localhost:8080/swagger-ui/index.html` url.  
  
## Technologies

---
- Java 17  
- Spring Boot 3.0  
- Open API Documentation  
- Spring Data JPA
[]( - H2 In Memory Database)  
- Restful API  
- Maven
[]( - Junit5)  
[]( - Mockito)
- Docker
[]( - Github Actions)  


## Prerequisites

---
- Maven or Docker
---

## Docker Run
The application can be built and run by the `Docker` engine. The project has a `Dockerfile`.


---
## Maven Run
To build and run the application with `Maven`, please follow the directions below;

```sh
$ cd earthquakes
$ mvn clean install
$ mvn spring-boot:run
```
You can reach the swagger-ui via  `http://{HOST}:8080/swagger-ui.html`

---    

## FUTURE WORKS ROADMAP

In no specific order:  
* crud methods with db integration with H2 and PostgreSQL  
* exception handling   
* authentication with OAuth2    
* connect more api than only USGS api  
* convert to microservices  
* some kafka integration  
* some redis integration  

--- 