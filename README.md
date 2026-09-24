# 🪙 Taxy — Taxes Made Fun for Kids

Taxy is a full-stack educational application designed to make taxes and basic money concepts easy and fun for kids.

Instead of teaching taxes using complicated financial terminology, Taxy explains concepts using simple, age-appropriate examples and interactive learning activities.

## 🚀 Current Features

- Calculate tax using a simple educational tax rate
- Age-based tax explanations for kids
- REST APIs built with Spring Boot
- Request validation using Jakarta Bean Validation
- Centralized exception handling
- Custom 404 handling for missing activities
- Store tax-learning activities in PostgreSQL
- Retrieve tax activity history
- Entity-to-DTO mapping
- Spring Data JPA and Hibernate persistence

## 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation
- Maven

### Database
- PostgreSQL

### Frontend — Coming Next
- React
- HTML / CSS / JavaScript

### AI — Planned
- AI-powered tax tutor
- Age-appropriate explanations
- Interactive questions and learning assistance

## 🏗 Architecture

Taxy currently follows a layered backend architecture:

Client  
↓  
Controller  
↓  
Service  
↓  
Repository  
↓  
JPA / Hibernate  
↓  
PostgreSQL

DTOs are used for API requests and responses so that database entities are not directly exposed through the REST API.

## 📚 API Examples

### Calculate Tax

`POST /api/tax/calculate`

Example request:

{
  "income": 250,
  "age": 7
}

Example response:

{
  "income": 250,
  "tax": 25,
  "moneyLeft": 225,
  "explanation": "You earned $250..."
}

### Get Tax History

`GET /api/tax/history`

### Get Tax Activity by ID

`GET /api/tax/history/{id}`

## 🔐 Security

Database credentials are not stored in the source code.

The PostgreSQL password is provided through the `DB_PASSWORD` environment variable.

## 🗺 Roadmap

- Kids profile and age groups
- Interactive tax quizzes
- Points and rewards
- React user interface
- AI-powered learning assistant
- Unit and integration testing
- API documentation
- CI/CD pipeline
- Cloud deployment

## ⚠️ Educational Purpose

Taxy is an educational project.

The tax calculations used in the application are simplified examples for teaching purposes and should not be considered real tax or financial advice.