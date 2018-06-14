# Spring Boot with JSF and Hibernate

### POM

* JSF 2.2 (Glassfish)
* Spring Boot 1.5.13.RELEASE
* Java 8
* H2 database
* Hikari CP


### Notes

This version does NOT use a **web.xml** file.

It does use a **faces-config.xml** file to configure SpringBeanFacesElResolver.


### Deployment

This is a standard Maven project: *mvn clean install*

Launch the Spring Boot application and connect to: *http://localhost:8091/home.jsf*
