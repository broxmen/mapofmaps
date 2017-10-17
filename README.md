# Full-Stack Development Project - Map of Maps

This program is a free-software; created by the team of Scholar (2017) batch (SAP Labs India-Concur)

* Date: 2017-09-21 12:35:00  
* Team: Service Innovation
* Version: 1.1


## Table of Contents:

* Introduction
* Software Installation
* Driving the software


### 1. Introduction

The software entails the usage and knowledge of front-end, services, and back-end technologies in such a way that together, when integrated, they form a complete working project that allows the users to create an initial and a final map, and run an algorithm that compares the two maps in such a way that each map's content (another sub-map or content) is compared.

### 2. Software Installation

The following software need to be installed and run:

1. Springboot Tool Suite

The local back-end server can be run using the following command in the root folder:

```shell
java -jar Maps.java
```

The Jar file spins up a local tomcat server that can handle all the request/reply to the angular UI.

Once the web-service runs successfully, the user reaches out to:

[localhost:8080/compare](localhost:8080/)

This allows the Service to receive the request to carry out the operations.

<!-- This is responsible to help run the Web Service for our project, that will link the User Interface with the Core-Logic. To install STS, you need to install the [Java Development Kit (JDK)](https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwj_sb_N3rXWAhVJKY8KHegIB0gQFggnMAA&url=http%3A%2F%2Fwww.oracle.com%2Ftechnetwork%2Fjava%2Fjavase%2Fdownloads%2Findex.html&usg=AFQjCNG9HwUyCVwOIeJtJFVQ2YKXrRFNmg) version 1.8.0_144.

Along with the same, the user needs to install the [Springboot Tool Suite](https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwjm5L-F37XWAhXJvI8KHfKaBcEQFggnMAA&url=https%3A%2F%2Fspring.io%2Ftools%2Fsts%2Fall&usg=AFQjCNFxdvECL8gmUMX84tBTkSNC3NN9dA) version 3.9.0. -->


2. Angular

Angular 4 is the version used to create the User Interface of the project. To run the Angular Development Environment, install Node JS. Verify that you are running at least node 6.9.x and npm 3.x.x by running node -v and npm -v in a terminal/console window.

Refer to [this](https://angular.io/guide/quickstart) link till step 1 to complete the installation of Angular CLI.

To run the Angular local server inside the angular folder, run:
```shell
npm install
```
This will load all the dependencies of the project. Once it is completed run this command to start the localhost server.

```shell
ng serve
```

The angular UI after successful build of the same, would run at:

[localhost:4200/](localhost:4200/)

#### NOTE
* To allow cross-origin request to the project, the user needs to install [this](https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi) extension for chrome.

### 3. Driving

The user Interface can be viewed at [localhost:4200/](localhost:4200/). This will load the home page where the user can enter the details.

* First the user enters the number of maps needed and loads in the left map
* The user expands the number of maps which contains 2 key-value pairs
* After this the user saves the left map by clicking on the save button
* Similarly the user loads in the right map
* The user can now click on the compare button and load in the compare page
* This page sends the left and right maps to the backend and gets the response back from the server
* The response contains the list of all elements which are of status
  - Changed
  - Unchanged
  - Added
  - Deleted
* This result is interpreted by the angular UI and shown on the table which are also color coded to indicate the changes in the two maps
