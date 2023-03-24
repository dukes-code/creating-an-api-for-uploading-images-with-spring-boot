# Creating an API for uploading images with Spring Boot

Repository used during the development of an article on DukesCode about ["Creating an API for uploading images with Spring Boot and PostgreSQL"](https://www.dukescode.com/creating-an-api-for-uploading-images-with-spring-boot?utm_source=github&utm_medium=page&ref=github).

[![LinkedIn](https://img.shields.io/static/v1?label=LinkedIn&message=%20&color=blue&logo=LinkedIn&style=flat-square&logoColor=white)](https://www.linkedin.com/in/dukefullstack/)
[![Youtube](https://img.shields.io/static/v1?label=Youtube&message=%20&color=blue&logo=Youtube&style=flat-square&logoColor=white)](https://www.youtube.com/@DukesCode)
[![Twitter](https://img.shields.io/static/v1?label=Twitter&message=%20&color=blue&logo=Twitter&style=flat-square&logoColor=white)](https://twitter.com/dukefullstack)
[![DukesCode](https://img.shields.io/static/v1?label=Duke'sCode&message=%20&color=blue&logo=googlechrome&style=flat-square&logoColor=white)](https://dukescode.com?utm_source=github&utm_medium=page&ref=github)
[![Instagram](https://img.shields.io/static/v1?label=Instagram&message=%20&color=blue&logo=Instagram&style=flat-square&logoColor=white)](https://www.instagram.com/dukefullstack/)

## ![image](https://github.com/dukefullstack/store-app-castore/blob/assets/assets/octohub.png?raw=true) Menu Contents

- [Creating an API for uploading images with Spring Boot](#creating-an-api-for-uploading-images-with-spring-boot)
  - [:bulb: Menu Contents](#-menu-contents)
  - [:pushpin: Motivation](#pushpin-motivation)
  - [:man_technologist: Technologies & Tools](#man_technologist-technologies--tools)
  - [:iphone: Final Application](#iphone-final-application)
  - [:heavy_check_mark: Installation](#heavy_check_mark-installation)
  - [:heavy_check_mark: Compilation & Test](#heavy_check_mark-compilation--test)
  - [:pencil: Author](#pencil-author)

## :pushpin: Motivation

At one point, our team encountered a situation where we had to develop a file upload and download service because our current file sharing service with partners utilized AWS S3.

The objective of this article is to demonstrate a straightforward approach to creating a service that employs Spring Boot and PostgreSQL to upload and store BLOB files in the database. Read on for a step-by-step guide.

## :man_technologist: Technologies & Tools

- Java 17
- Spring Boot 3.02
- Maven 3.9.0
- Spring Data JPA
- PostgreSQL
- Lombok

## :iphone: Final Application

By the conclusion of this article, we will have successfully generated a REST API that enables the uploading and downloading of files while also persisting them in the database. Follow along to learn how to create this API through a series of clear steps.

- Upload any type of file.

- Download files uploaded.

- Persist files on PostgreSQL.

## :heavy_check_mark: Installation

- First, you need to have Java 17, Maven 3.9.0 and a instance of PostgreSQL, then clone the project via HTTPS through this command:</br>
  `$ git clone https://github.com/dukes-code/creating-an-api-for-uploading-images-with-spring-boot.git`

- After cloning, enter the cloned repository directory:</br>
  `$ cd https://github.com/dukes-code/creating-an-api-for-uploading-images-with-spring-boot.git`

- Once being inside the directory, download and install the dependencies using:</br>
  `$ mvn install`

## :heavy_check_mark: Compilation & Test

- To compile you must run at terminal:</br>
  `$ mvn clean package`

- To run our tests you must access your terminal and run:</br>
  `$ mvn spring-boot:run`

## :pencil: Author

- <a href="https://www.linkedin.com/in/dukefullstack/" target="_blank">LinkedIn</a>
- <a href="https://www.youtube.com/@DukesCode" target="_blank">Youtube</a>
- <a href="https://twitter.com/dukefullstack" target="_blank">Twitter</a>
- <a href="https://dukescode.com?utm_source=github&utm_medium=page&ref=github" target="_blank">Duke's Code</a>
- <a href="https://www.instagram.com/dukefullstack/" target="_blank">Instagram</a>

Made with :heart: by <a href="https://www.linkedin.com/in/dukefullstack/">**Thiago Santos Joaquim**</a>. MIT License
