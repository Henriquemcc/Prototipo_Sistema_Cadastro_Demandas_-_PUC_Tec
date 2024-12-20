[Versão em Português](README.md)

# Prototype of the PUC Tec Demand Registration System

This repository contains the prototype of the PUC Tec Demand Registration System Back-End, developed at [PUC Tec Startup Support Service (SA PUC Tec)](https://www.pucminas.br/puctec/Paginas/default.aspx) to meet an internal demand of PUC Tec.

## Introduction

PUC Tec is an acceleration program for startups developed by students of the Pontifical Catholic University of Minas Gerais. One of the ways in which PUC Tec helps startups is by forwarding demands from companies to interns in the PUC Tec internship program. These students are guided by professors in their respective areas of knowledge and must deliver what was requested to the requesting startup within the specified deadline.

One of the difficulties encountered by PUC Tec employees, professors and students is in managing these demands, resulting in repetitive manual work that is prone to errors. In order to solve these difficulties and increase productivity and efficiency, it was proposed the development of a software system responsible for managing the demands coming from PUC Tec startups.

## Requirements

The following requirements were collected for the development of this system:

### Functional

- Allow monitoring and modification of the life cycle and status of a demand on a kanban board.
- Allow startups to create demands.
- Allow PUC Tec employees to accept, reject, change (the deadline) or redirect demands.
- Allow professors (in the case of IT) to accept, reject, change (the deadline) or redirect demands.
- Allow specifying the types of students, without having to change the program.
- Allow students to submit different types of submissions (links, comments, reports).
- Allow startups to specify the type of delivery desired.
- The system must have a login and password.
- Allow PUC Tec employees to register startups, students and professors.

### Non-Functional

- The system website must be accessible from both desktop and mobile web browsers.
- The system's Back-End must be developed in the Kotlin programming language with the Spring Boot framework.
- The system's Front-End must be developed using the TypeScript programming language and the React and Tailwind CSS frameworks.
- The database used by the Back-End will be defined soon.

## Project

To develop this system, a database project was developed using the [Extended Entity Relationship Diagram (EER)](./docs/Diagrama_Entidade_Relacionamento_Estendido.png), and then an [Entity Relationship project in MySQL WorkBench](./docs/MySQL_Model.mwb) project was built.

## Implementation

To implement this prototype, the [Spring Boot](https://spring.io/) framework was used along with the [Kotlin](https://kotlinlang.org/) programming language. And for the database, [MySQL](https://www.mysql.com/) was used.

## System Requirements

To run this program, is required to have installed the following programs:

- Java Development Kit (version 21 or higher)
- Docker

## How to run

To run this program, open a terminal (or command prompt) in the project folder and type the following command:

In Linux and Mac Terminal:

```
./gradlew bootRun
```

In Windows Command Prompt, Terminal or PowerShell:

```
gradlew bootRun
```

## How to test

To test the operation of this program, install [Postman](https://www.postman.com/) and import the [Postman Collection](postman_collection.json), and perform the desired requests.