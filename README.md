# rainy-hills: RainyHills Using JAX-RS (Java API for RESTful Web Services), JAX-WS and stateless EJB 3.2

[![Build Status](https://travis-ci.org/Iurii-Dziuban/rainy-hills.svg?branch=master)](https://travis-ci.org/Iurii-Dziuban/rainy-hills)

Author: Iurii Dziuban  
Technologies: CDI, JAX-RS, JAX-WS, EJB
Summary: The `rainy-hills` demonstrates a simple Rainy Hills J2EE 7 application, 
bundled and deployed as a WAR, that uses *JAX-RS* to solve RainyHills problem.    
 

## What is it? Project parts and libs

The `rainy-hills` demonstrates the use of *CDI* , *JAX-RS*, *JAX-WS* and *EJB*

- main package contains REST Controller, SOAP webservice and SOAP client
- `contract` contains interfaces. It is good practice to use interfaces instead of directly using implementations
- `service` contains normal java service bean
- `ejb` contains ejb bean

application dependencies:

- j2ee libraries
- guava for utilities

test dependencies:
-JUnit - main test framework
-Assertj - fluent assertions instead of using JUnit with hamcrest
-BDDMockito - mocking framework using BDD style.

## System Requirements

The application this project produces is designed to be run on Wildfly 11.0.0 version or later.

At least java 7 should be installed on PC <https://java.com/en/download/>

Maven latest version should be installed from <https://maven.apache.org/download.cgi>

All you need to build this project is to run `mvn clean install` (unit tests will be executed as well)

Wildfly 11.0.0 should be downloaded to the machine from here <http://wildfly.org/downloads/> Java EE 7 Full and web distribution 

## Start the Server

1. Open a command prompt and navigate to the root of the Wildfly 11.0.0 directory.
2. The following shows the command line to start the server:

        For Linux:   ${jboss.home.name}/bin/standalone.sh
        For Windows: ${jboss.home.name}\bin\standalone.bat


## Build and Deploy the Rainy hills application

1. Make sure you have started the Wildfly 11.0.0 server as described above.
2. Open a command prompt and navigate to the root directory of this application.
3. Type this command to build and deploy the archive:

        mvn clean install wildfly:deploy

4. This will deploy `target/rainy-hills.war` to the running instance of the server.


## Access the Application

The application is deployed to <http://localhost:8080/rainy-hills/>.

Using JAX-RS: access the following URL: <http://localhost:8080/rainy-hills/rest/rainyhills?hills=2&hills=0&hills=0&hills=3>

using same query param name multiple times will produce an array of hills and values will be in the order they are typed in url
(It is the easiest and quickest way to test via browser for REST API, I came up with)

Using JAX-WS: run `mvn exec:java` which will invoke SOAP client `RainyHillsSoapWebserviceClient` 
or just run this main class from the IDE. Look at the output. Input can be changed inside `RainyHillsSoapWebserviceClient` 

## Undeploy the application

1. Make sure you have started the Wildfly 11.0.0 server as described above.
2. Open a command prompt and navigate to the root directory of this application.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy


## Deploy to Wildfly manually

Start the server as it is mentioned above.

Build the application with `mvn clean install`

Copy war file from `<application>/target/rainy-hills.war` to `<wildfly>/standalone/deployments`

It will be automatically picked up by the server and deployed

## Evaluation points covered

* correctness and clarity of the algorithm -> see RainyHillsEjb and RainyHillsEjbTest with many cases covered
* readable and maintainable code -> using interfaces, injections, frameworks for testing
* "real" enterprise application: 
layered - restController, service, ejb levels are provided (no need to go to dao, db layers) 
testable - unit tests are provided
deployable - possibility to deploy to Wildfly is covered 
documented - comments are added to algorithm and implementations, README is provided
