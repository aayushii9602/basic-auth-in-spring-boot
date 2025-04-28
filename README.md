This is a Spring Boot project using Spring Security for basic authentication. It loads users from a custom UserService, stores them in memory, and protects all endpoints except /user/signup. Passwords are encrypted using BCrypt, and authentication is handled with HTTP Basic Auth.

# JWT Authentication in Spring Boot

This project implements JWT-based authentication for securing a Spring Boot application. It ensures that only authenticated users can access protected resources using JSON Web Tokens (JWTs). Below is an overview of the steps taken to implement this feature.

## Key Features Implemented:

### 1. **JWT Authentication Entry Point**
- Created a custom entry point that handles unauthorized access attempts. When a user tries to access a protected resource without proper authentication, this component returns an "Unauthorized" response.

### 2. **JWT Helper Utility**
- Developed a helper class responsible for generating, validating, and parsing JWT tokens. It provides methods to extract user details (like username) from the token and validate the token’s expiration.

### 3. **JWT Authentication Filter**
- Implemented a custom filter that intercepts incoming requests, extracts the JWT from the `Authorization` header, validates it, and sets the authentication context if the token is valid.

### 4. **Spring Security Configuration**
- Configured Spring Security to support JWT authentication, disabling CSRF, and setting the application to stateless session management. This ensures that the application does not store session information and relies purely on JWT tokens for authentication.

### 5. **User Authentication Endpoint**
- Developed an endpoint for user login, where users submit their credentials (email and password). If valid, the server responds with a JWT token that can be used to authenticate subsequent requests.

### 6. **Exception Handling**
- Implemented error handling to manage authentication issues, such as invalid credentials, expired tokens, or malformed tokens, ensuring that appropriate error messages are returned to the client.

### 7. **Secure Access to Resources**
- Protected application resources using JWT tokens. Users must include the token in the `Authorization` header of their requests to access endpoints that require authentication.

## How It Works:
1. **Login**: A user submits their email and password to the login endpoint. If the credentials are valid, the server returns a JWT token.
2. **Token Usage**: The user includes the JWT token in the `Authorization` header of subsequent requests. The server verifies the token, and if valid, grants access to the requested resource.
3. **Stateless Authentication**: The application doesn’t store session information. It relies on the JWT token for authentication, making the system stateless.

## Summary:
This project demonstrates how to secure a Spring Boot application using JWT authentication. It ensures that only authenticated users can access protected resources, and the authentication process is stateless, relying entirely on JWT tokens. 
