# 🚀 E-commerce Hibernate Project

<p align="center">
  <img src="images/Ecommerce Hibernate Project Banner.png" alt="Ecommerce Hibernate Project Banner">
</p>
<p align="center">
  <b>A Java-based e-commerce application built using Hibernate ORM, JPA and MySQL.</b>
</p>
<p align="center">
  Demonstrates entity relationships, CRUD operations, order management and database integration.
</p>

---

## 📖 Overview

The **Ecommerce Hibernate Project** is a Java-based e-commerce application developed using **Hibernate ORM** and **MySQL**. 

The project demonstrates how Hibernate can be used to map Java objects to relational database tables and perform database operations using JPA annotations.

The application includes product categories, products, users, orders, and order details with appropriate relationships between the entities.

---

## 🛠️ Technologies Used

| Technology | Purpose |
| :--- | :--- |
| ☕ **Java** | Application development |
| 🍃 **Hibernate ORM** | Object-relational mapping |
| 📑 **JPA** | Entity mapping and persistence annotations |
| 🗄️ **MySQL** | Relational database |
| 📦 **Maven** | Dependency management |
| 💻 **Eclipse** | Development environment |

---

### Application Flow

```text
App.java
    ↓
CRUD Classes
    ↓
Hibernate SessionFactory / Session
    ↓
JPA Entity Classes
    ↓
Hibernate ORM
    ↓
MySQL Database
```

---

## 🔗 Entity Relationships

The project contains five main entities:

```text
Category
    │
    │ One-to-Many
    ↓
Product


Users
    │
    │ One-to-Many
    ↓
Orders
    │
    │ One-to-Many
    ↓
OrderDetails
    │
    │ Many-to-One
    ↓
Product
```

### Entity Summary

| Entity | Description |
| :--- | :--- |
| **Category** | Stores product categories |
| **Product** | Stores product information |
| **Users** | Stores user information |
| **Orders** | Stores customer orders |
| **OrderDetails** | Stores products included in an order |

---

## 📂 Project Structure

```text
EcommerceHibernate
│
├── src
│   └── main
│       ├── java
│       │   └── org
│       │       └── arghya
│       │           └── HibernateProject
│       │               │
│       │               ├── entity
│       │               │   ├── Category.java
│       │               │   ├── Product.java
│       │               │   ├── Users.java
│       │               │   ├── Orders.java
│       │               │   └── OrderDetails.java
│       │               │
│       │               ├── crud
│       │               │   ├── CreateCategory.java
│       │               │   ├── CreateProduct.java
│       │               │   ├── CreateUser.java
│       │               │   ├── CreateOrder.java
│       │               │   ├── ReadOrder.java
│       │               │   ├── UpdateProduct.java
│       │               │   └── DeleteProduct.java
│       │               │
│       │               └── App.java
│       │
│       └── resources
│           └── hibernate.cfg.xml
│
├── images
│   ├── ecommerce-banner.png
│
│
├── pom.xml
├── schema.sql
└── README.md
```

---

## 🏷️ Entities

### 1. Category
Stores information about product categories.
* **Fields:** `id`, `name`, `description`
* **Relationship:** Category `1` ──────── `Many` Product

### 2. Product
Stores information about products available in the store.
* **Fields:** `id`, `name`, `price`, `stockQuantity`, `category`
* **Relationship:** Product `Many` ──────── `1` Category

### 3. Users
Stores user information.
* **Fields:** `id`, `username`, `password`, `email`, `role`
* **Supported Roles:** `ADMIN`, `CUSTOMER`
* **Relationship:** Users `1` ──────── `Many` Orders

### 4. Orders
Stores information about customer orders.
* **Fields:** `id`, `orderDate`, `totalAmount`, `user`
* **Relationships:** 
  * Orders `Many` ──────── `1` Users
  * Orders `1` ──────── `Many` OrderDetails

### 5. OrderDetails
Stores the individual products included in an order.
* **Fields:** `id`, `quantity`, `unitPrice`, `order`, `product`
* **Relationships:**
  * OrderDetails `Many` ──────── `1` Orders
  * OrderDetails `Many` ──────── `1` Product

---

## ⚡ CRUD Operations

The project demonstrates the four basic database operations:

* **Create** (Implemented for Categories, Products, Users, Orders, OrderDetails)
  ```java
  session.persist(category);
  ```
* **Read** (Retrieves order details, user information, products, quantity, and unit price)
  ```java
  Orders order = session.get(Orders.class, 1);
  ```
* **Update** (Products can be updated)
  ```java
  product.setName("Gaming Laptop");
  product.setPrice(new BigDecimal("65000.00"));
  product.setStockQuantity(15);
  ```
* **Delete** (Products can be deleted using Hibernate)
  ```java
  session.remove(product);
  ```

---

## 🗄️ Database

* **Database Name:** `ecommerce`
* **Tables:** `category`, `product`, `users`, `orders`, `order_details`
* *The database schema is available in `schema.sql`.*

---

## ⚙️ Hibernate Configuration

Hibernate configuration is stored in `src/main/resources/hibernate.cfg.xml`.

The project uses:
```xml
<property name="hibernate.hbm2ddl.auto">
    update
</property>
```
This allows Hibernate to create or update database tables automatically according to the entity mappings.

---

## 🚀 How to Run

1. **Create the database:** Open MySQL and run:
   ```sql
   CREATE DATABASE ecommerce;
   ```
2. **Configure MySQL:** Open `src/main/resources/hibernate.cfg.xml` and set your MySQL username and password:
   ```xml
   <property name="hibernate.connection.username">root</property>
   <property name="hibernate.connection.password">YOUR_PASSWORD</property>
   ```
3. **Start MySQL:** Make sure your MySQL server is running before executing the application.
4. **Update Maven:** In Eclipse, right-click the project → **Maven** → **Update Project**.
5. **Run the Application:** Run `App.java` as a **Java Application**.

---

## 📦 Maven Dependencies

The project uses Maven for dependency management (`pom.xml`). Main dependencies include:
* Hibernate Core
* MySQL Connector
* JUnit

---

## ✨ Features

* ✅ Hibernate ORM integration
* ✅ JPA entity mapping
* ✅ MySQL database integration
* ✅ One-to-Many & Many-to-One relationships
* ✅ Cascade operations & Lazy fetching
* ✅ CRUD operations & Order management
* ✅ Maven project structure & Database schema file

---

## 📁 Important Files

| File | Purpose |
| :--- | :--- |
| `App.java` | Application entry point |
| `hibernate.cfg.xml` | Hibernate configuration |
| `pom.xml` | Maven dependencies |
| `schema.sql` | Database schema |
| `Category.java` | Category entity |
| `Product.java` | Product entity |
| `Users.java` | User entity |
| `Orders.java` | Order entity |
| `OrderDetails.java` | Order details entity |

---

## 🎯 Learning Objectives

This project demonstrates:
* Object-relational mapping using Hibernate
* JPA annotations and entity relationships
* Session and transaction management
* CRUD operations and persistence
* MySQL integration and Maven-based project workflows
