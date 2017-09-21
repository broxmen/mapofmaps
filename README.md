# Full-Stack Development & PhantomJS Project 

This program is a free-software; created by the team of Scholar (2017) batch (SAP Labs India-Concur) 

* Date: 2017-09-21 12:35:00  
* Team: Service Innovation
* Version: 1.0


## Table of Contents: 

* Introduction 
* Software Installation 
* Driving the software


### 1. Introduction 

The software entails the usage and knowledge of front-end, services, and back-end technologies in such a way that together, when integrated, they form a complete working project that allows the users to create an initial and a final map, and run an algorithm that compares the two maps in such a way that each map's content (another sub-map or content) is compared. 

### 2. Software Installation 

The following software need to be installed and run: 

1. Springboot Tool Suite 

This is responsible to help run the Web Service for our project, that will link the User Interface with the Core-Logic. To install STS, you need to install the [Java Development Kit (JDK)](https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwj_sb_N3rXWAhVJKY8KHegIB0gQFggnMAA&url=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Fjava%2Fjavase%2Fdownloads%2Findex.html&usg=AFQjCNG9HwUyCVwOIeJtJFVQ2YKXrRFNmg) version 1.8.0_144. 
Along with the same, the user needs to install the [Springboot Tool Suite](https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwjm5L-F37XWAhXJvI8KHfKaBcEQFggnMAA&url=https%3A%2F%2Fspring.io%2Ftools%2Fsts%2Fall&usg=AFQjCNFxdvECL8gmUMX84tBTkSNC3NN9dA) version 3.9.0. 


2. Angular JS

Angular 4 is the version used to create the User Interface of the project. To run the Angular Development Environment, install Node.JS and npm. Inside the Angular Directory, run the command: 

```javascript
npm install 
```
Refer to [this](https://angular.io/guide/quickstart) link to complete the installation
This command will load all the dependencies. 
Verify that you are running at least node 6.9.x and npm 3.x.x by running node -v and npm -v in a terminal/console window. 

To run the Angular local server, run: 
```javascript
ng serve 
```
The User Interface afte successful installation of the same, would run at: 

[localhost:4200/](localhost:4200/)

**To allow cross-origin request to the project, the user needs to install [this](https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi) extension. 

### 3. Driving 

Running the software entails setting up the Web-Service, which is carried out using STS (discussed at 2.1). To run the service, we Install the Maven for the Application created, and then run the service using the Controller. 


Once the web-service runs successfully, the user reaches out to: 

[localhost:8080/compare](localhost:8080/) 

This allows the Service to receive the request to carry out the operations. 

