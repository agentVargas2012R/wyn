# Built With Spring Initializr
https://start.spring.io/

# PreReq's
- Java 17
- Open Network/Proxy Configuration (if behind corporate firewall)
- Gradle
- Spring 3.0.0
- SpringDoc OpenAPI 
- H2 In Memory Database

# Set Up
- Import the project at the API folder level as it contains the gradle settings.

## Demo Application

This is a contact rest api using Spring 5 + H2 DB to showcase interacting with a 
datastore and responding to a rest style endpoint. 

The endpoints are:

```
    GET - /contacts
        returns all contacts
        
    GET - /contacts/{contactId}
        returns a specific contact
        
    POST - /contacts
        returns a newly post contact
    
    PUT - /contact
        updates a contact
        
    DELETE - /contact/{contactId}
        removes a contact 
```
# SpringDoc Swagger
An interactive swagger client is available at this endpoint.
```
    /swagger-ui/index.html
```

# Postman Collection 

A postman is provided in the postman folder. You can use this to interact 
with the api to see how it works.

A few notes, the spring app is configured to show errors and stack trace messages 
and currently has H2 console enabled.







