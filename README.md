# E-Shop Domain Project

This project implements a core domain model for an E-Shop system, designed for unit testing practice.

## Main Application Paths

The logical flow of the application follows these steps:

1.  **Product Creation**: 
    - `Product` is the base abstract class.
    - `PhysicalProduct` (with weight, shipping) and `DigitalProduct` (with download URL) are concrete implementations.
2.  **Shopping Cart**:
    - Users add products to a `Cart`.
    - `Cart` manages line items (`CartItem`) and calculates totals.
3.  **Order Processing**:
    - The `OrderService` converts a `Cart` into an `Order`.
    - It integrates with a `PaymentProcessor` (Interface) to handle payments.
    - If payment succeeds, the order is marked as `PAID`.

## Requirements

- **Java**: JDK 25 (or latest comparable JDK available in your environment, configured in `pom.xml` as 25).
- **Maven**: 3.6+

## How to Run the Application

You can run the demonstration `App` class using Maven:

```bash
mvn compile exec:java -Dexec.mainClass="com.example.eshop.App"
```

This will execute the main method which:
1.  Creates sample products.
2.  Adds them to a cart.
3.  Processes a mock payment and places an order.
4.  Prints the results to the console.

## How to Run Tests

The project uses **JUnit 5** for unit testing.

To run all tests:

```bash
mvn test
```

To run a specific test class:

```bash
mvn -Dtest=AppTest test
```