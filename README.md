
# Spring Security CSRF Configuration

A Spring Boot application showcasing CSRF configuration, public endpoints, and HTTP Basic authentication using Spring Security.

## 🚀 Overview

Cross-Site Request Forgery (CSRF) is a security vulnerability in which an attacker tricks an authenticated user's browser into performing unwanted actions on an application.

This project demonstrates how to disable CSRF protection and configure endpoint authorization using Spring Security.

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- Maven
- REST API

## ⚙️ Security Configuration

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/public", "/api/addUser")
            .permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
}
```

## 🔍 Configuration Explained

### 1. Disable CSRF Protection

```java
.csrf(csrf -> csrf.disable())
```

- Disables CSRF protection in Spring Security.
- Demonstrates CSRF configuration for REST APIs.
- Should only be used when appropriate for the application's authentication mechanism.

### 2. Permit Public Endpoints

```java
.requestMatchers("/api/public", "/api/addUser")
.permitAll()
```

The following endpoints are accessible without authentication:

- `/api/public`
- `/api/addUser`

### 3. Secure Remaining Endpoints

```java
.anyRequest().authenticated()
```

- Requires authentication for all other endpoints.
- Unauthenticated requests to protected endpoints are rejected.

### 4. Enable HTTP Basic Authentication

```java
.httpBasic(Customizer.withDefaults())
```

- Enables HTTP Basic authentication.
- Credentials are sent through the `Authorization` header.
- HTTPS should be used to protect credentials in transit.

## 🔐 Endpoint Authorization

| Endpoint | Access |
|---|---|
| `/api/public` | Public |
| `/api/addUser` | Public |
| All other endpoints | Authentication Required |

## 🧪 Testing the API

### Public Endpoint

```bash
curl http://localhost:8080/api/public
```

### Protected Endpoint

```bash
curl -u username:password http://localhost:8080/api/protected
```

Replace the credentials and endpoint with values configured in your application.

## 🤔 Why Disable CSRF?

CSRF attacks exploit the browser's ability to automatically attach credentials, such as session cookies, to requests.

Disabling CSRF may be appropriate when an API does not rely on browser-automatically-sent credentials.

**Important:** HTTP Basic authentication can still expose an application to CSRF because browsers may automatically send cached credentials. Stateless session management alone does not eliminate CSRF risks.

## 📚 Learning Objectives

- Understand CSRF protection in Spring Security.
- Configure `SecurityFilterChain`.
- Allow public access to selected endpoints.
- Secure endpoints using HTTP Basic authentication.
- Understand the security implications of disabling CSRF.

## ▶️ Getting Started

### Prerequisites

- Java version compatible with your Spring Boot version
- Maven

### Clone the Repository

```bash
git clone https://github.com/<your-username>/spring-security-csrf-configuration.git
cd spring-security-csrf-configuration
```

### Run the Application

```bash
./mvnw spring-boot:run
```

For Windows:

```bash
mvnw.cmd spring-boot:run
```

If Maven Wrapper is unavailable, run:

```bash
mvn spring-boot:run
```

Replace `<your-username>` with your GitHub username.

## ⚠️ Security Note

This project is intended for learning purposes. Stateless APIs are not automatically immune to CSRF attacks. Evaluate your authentication mechanism and security requirements before disabling CSRF protection.

## 👨‍💻 Author

**Motilal Gupta**
