# Wishlist Item Management System

## Overview

This project is a backend implementation for a Wishlist Item Management System. It provides a set of RESTful API endpoints for users to manage their wishlists securely.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 17
- Maven
- MySQL database

## Setup Instructions

1. Clone the repository.
2. Configure the database in `application.properties`.
3. Run the application using Maven: `mvn spring-boot:run`.

## API Endpoints

### User Authentication

- `/auth/create-user` (POST): Create a new user.
- `/auth/login` (POST): Authenticate and log in.

### Wishlist Management

- `/api/wishlists` (GET): Retrieve user's wishlist.
- `/api/wishlists` (POST): Create a new wishlist item.
- `/api/wishlists/{id}` (DELETE): Remove a wishlist item by ID.

Ensure that only authenticated users can access and manage their wishlists.

## Database 
 - user_table will be created automatically which will store all the users we create.
 - wishist_entity will also be created automatically will store wish list items
 - wishlist_entity will have @manyToOne relation with user_table, as 1 user can have multiple wishlist items.


## Testing

Run unit tests to validate the functionality of wishlist-related components. Use the following command:

```bash
mvn test

