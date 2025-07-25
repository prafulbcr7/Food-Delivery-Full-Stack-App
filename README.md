# Food Delivery Microservices System

A food delivery platform built using Spring Boot microservices architecture with Netflix Eureka for service discovery and inter-service communication.

## Architecture Overview

This system follows a microservices architecture pattern with the following services:

- **Eureka Service Registry** - Service discovery and registration
- **User Info Service** - User management and authentication
- **Restaurant Listing Service** - Restaurant information management
- **Food Catalogue Service** - Food items and menu management
- **Order Service** - Order processing and management

## Technologies Used

- **Java 21** (Eclipse Adoptium)
- **Spring Boot** - Microservices framework
- **Spring Cloud Netflix Eureka** - Service discovery
- **Spring Data JPA** - Data persistence
- **MapStruct** - Object mapping
- **Maven** - Build tool and dependency management
- **RestTemplate** - Inter-service communication

## Service Details

### 1. Eureka Service Registry
- **Purpose**: Service discovery and registration
- **Port**: 8761 (Typically)
- **Location**: [`eureka/`](eureka/)

### 2. User Info Service
- **Purpose**: Manages user information and profiles
- **Key Components**:
  - [`UserService`](userInfo/src/main/java/com/codemaster/userInfo/service/UserService.java) - Core business logic
  - [`UserMapper`](userInfo/src/main/java/com/codemaster/userInfo/mapper/UserMapper.java) - DTO/Entity mapping
- **Location**: [`userInfo/`](userInfo/)

### 3. Restaurant Listing Service
- **Purpose**: Manages restaurant information and listings
- **Location**: [`restaurantlisting/`](restaurantlisting/)

### 4. Food Catalogue Service
- **Purpose**: Manages food items and restaurant menus
- **Key Components**:
  - [`FoodCatalogueController`](foodCatalogue/src/main/java/com/codemaster/foodCatalogue/controller/FoodCatalogueController.java) - REST endpoints
  - [`FoodCatalogueService`](foodCatalogue/src/main/java/com/codemaster/foodCatalogue/service/FoodCatalogueService.java) - Business logic
  - [`FoodItemMapper`](foodCatalogue/src/main/java/com/codemaster/foodCatalogue/mapper/FoodItemMapper.java) - Object mapping
- **Location**: [`foodCatalogue/`](foodCatalogue/)

### 5. Order Service
- **Purpose**: Handles order processing and management
- **Key Components**:
  - [`OrderService`](order/src/main/java/com/codemaster/order/service/OrderService.java) - Order processing logic
- **Location**: [`order/`](order/)

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd SpringBoot-Microservices-FoodDelivery
```

### 2. Build All Services
Navigate to each service directory and build:

```bash
# Build Eureka Service
cd eureka
./mvnw clean install

# Build User Info Service
cd ../userInfo
./mvnw clean install

# Build Restaurant Listing Service
cd ../restaurantlisting
./mvnw clean install

# Build Food Catalogue Service
cd ../foodCatalogue
./mvnw clean install

# Build Order Service
cd ../order
./mvnw clean install
```

### 3. Start Services (In Order)

**Step 1**: Start Eureka Service Registry
```bash
cd eureka
./mvnw spring-boot:run
```

**Step 2**: Start all other services (can be started in parallel)
```bash
# Terminal 2 - User Info Service
cd userInfo
./mvnw spring-boot:run

# Terminal 3 - Restaurant Listing Service
cd restaurantlisting
./mvnw spring-boot:run

# Terminal 4 - Food Catalogue Service
cd foodCatalogue
./mvnw spring-boot:run

# Terminal 5 - Order Service
cd order
./mvnw spring-boot:run
```

## API Endpoints

### Food Catalogue Service
- `POST /foodCatalogue/addFoodItem` - Add new food item
- `GET /foodCatalogue/fetchRestaurantAndFoodItemById/{restaurantId}` - Get restaurant menu

### User Info Service
- `GET /user/fetchAllUsers` - Get all users
- `POST /user/addUser` - Add new user
- `GET /user/fetchUserById/{id}` - Get user by ID

### Order Service
- `POST /order/saveOrder` - Create new order

## Inter-Service Communication

Services communicate with each other using RestTemplate and service names registered with Eureka:

- **Food Catalogue → Restaurant Listing**: `http://RESTAURANT--SERVICE/restaurant/fetchById/{id}`
- **Order → User Info**: `http://USER--SERVICE/user/fetchUserById/{userId}`

## Project Structure

```
├── eureka/                     # Service Registry
├── userInfo/                   # User Management Service
├── restaurantlisting/          # Restaurant Service
├── foodCatalogue/             # Food Catalogue Service
├── order/                     # Order Management Service
└── README.md                  # This file
```

Each service follows standard Spring Boot structure:
```
service-name/
├── src/main/java/com/codemaster/servicename/
│   ├── controller/            # REST Controllers
│   ├── service/              # Business Logic
│   ├── entity/               # JPA Entities
│   ├── dto/                  # Data Transfer Objects
│   ├── mapper/               # MapStruct Mappers
│   └── repo/                 # JPA Repositories
├── src/main/resources/
├── pom.xml
└── mvnw, mvnw.cmd           # Maven Wrapper
```

## Development Notes

- All services use **Maven Wrapper** for consistent build environment
- **MapStruct** is used for efficient object mapping between DTOs and entities
- Services are designed to be **stateless** and **independently deployable**
- **Eureka Client** configuration enables automatic service registration

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## Future Enhancements

- Add Spring Security for authentication
- Implement API Gateway (Spring Cloud Gateway)
- Add distributed tracing (Zipkin/Sleuth)
- Containerize services with Docker
- Add comprehensive unit and integration tests
- Implement circuit breaker pattern (Hystrix/Resilience4j)

