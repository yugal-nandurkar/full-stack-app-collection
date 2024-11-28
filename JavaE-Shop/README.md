# eShop Reference Application - "AdventureWorks"

A reference Spring application implementing an e-commerce website using a services-based architecture using Java.
Spring Boot Reference Application - "AdventureWorks"
Architecture Diagram
![eShop Reference Application architecture diagram](img/eshop_architecture.png)

![eShop homepage screenshot](img/eshop_homepage.png)

Getting Started
Prerequisites
Install Docker
Follow the Docker installation guide.

Install Java Development Kit (JDK)
Install Java 17 or higher.

Install Maven or Gradle
Install Maven or Gradle for build automation.

Install IDE
Use IntelliJ IDEA or Eclipse with the following plugins:

Spring Boot
Lombok
Docker integration (optional)
Setup Instructions
Clone the repository:
bash
Copy code
git clone https://github.com/your-repo/adventureworks.git
cd adventureworks
Running the Application
Using IDE
Open the project in IntelliJ IDEA or Eclipse.
Set up the adventureworks-api module as the main application.
Run the Spring Boot application from the main class:
java
Copy code
@SpringBootApplication
public class AdventureWorksApplication {
public static void main(String[] args) {
SpringApplication.run(AdventureWorksApplication.class, args);
}
}
Using CLI
Start the application using Maven:
bash
Copy code
mvn spring-boot:run
Or using Gradle:
bash
Copy code
./gradlew bootRun
Accessing the Application
Open the dashboard URL:
arduino
Copy code
http://localhost:8080
Environment Variables
Use a .env file to manage configurations:

env
Copy code
SPRING_PROFILES_ACTIVE=local
BASE_URL=http://localhost:8080
DB_CONNECTION_STRING=jdbc:mysql://localhost:3306/adventureworks
Alternatively, manage these in application.properties:

properties
Copy code
spring.profiles.active=local
base.url=http://localhost:8080
db.connection-string=jdbc:mysql://localhost:3306/adventureworks
Deploying with Docker
Build Docker Image

bash
Copy code
docker build -t adventureworks-api .
Run the Container

bash
Copy code
docker run -p 8080:8080 --env-file .env adventureworks-api
Stop and Remove Containers

bash
Copy code
docker stop adventureworks-api && docker rm adventureworks-api
Azure Deployment
Install the Azure CLI and log in:

bash
Copy code
az login
Deploy the application using Maven or Gradle with Azure support:

bash
Copy code
mvn azure-webapp:deploy
Access the deployed application URL:

arduino
Copy code
https://<your-app-name>.azurewebsites.net
Contributing
Refer to CONTRIBUTING.md and the Code of Conduct for contribution guidelines.

Sample Data
Product data and images can be defined in JSON or embedded in the database. Example structure:

json
Copy code
[
{
"id": 1,
"name": "Mountain Bike",
"description": "A durable mountain bike for all terrains.",
"brand": "AdventureWorks",
"price": 1200.00,
"imageUrl": "/images/mountain-bike.png"
}
]
Images can be stored in an assets/images folder or linked to an external CDN.

This document provides the steps and configurations needed to set up and run the application with
Spring Boot while maintaining parity with the .NET Aspire eShop reference application.

