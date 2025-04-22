# Ambassador Pattern Demo - Spring Boot with Docker

## Overview

This project demonstrates the **Ambassador Pattern** using **Spring Boot** microservices and **Docker**. The Ambassador Pattern acts as a proxy between the client and external services, providing stability, fault tolerance, and scalability, even in the face of unreliable third-party services.

The demo includes:
- **Mock API Service** simulating an external service.
- **Client Service** that interacts with the Mock API via the Ambassador Proxy.
- **Ambassador Proxy** implementing the Ambassador Pattern, adding resilience between the client and external API.

### Key Benefits
- **Resilience**: Protects from failures of third-party services.
- **Scalability**: Scales independently from client and external services.
- **Maintainability**: Provides a consistent interface for clients, abstracting complexity.

## Architecture

The architecture consists of three Spring Boot services:
1. **Mock API**: A service simulating the behavior of an external system.
2. **Ambassador Proxy**: A proxy service that sits between the client and the mock API, handling retries and fault tolerance.
3. **Client Service**: Interacts with the Ambassador Proxy instead of the Mock API directly.

### Why WebFlux?
**WebFlux** is used in the Proxy and Client services to handle asynchronous, non-blocking communication, improving the system's responsiveness and scalability when dealing with external services.

## Services

- **mock-api**: Simulates an external service.
- **ambassador-proxy**: Acts as the intermediary proxy service.
- **client-service**: Makes requests to the proxy instead of directly accessing the mock API.

## License

This project is open source and available under the [MIT License](LICENSE).
