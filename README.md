# 📚 Library Management System

A web-based Library Management System built with **Java Servlets, JSP, JDBC, and Maven** — following the **MVC + DAO** design pattern and demonstrating core OOP concepts.

![Java](https://img.shields.io/badge/Java-11-blue)
![Servlet](https://img.shields.io/badge/Servlet-4.0-orange)
![Maven](https://img.shields.io/badge/Maven-3.8-red)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)

---

## ✨ Features

- 📖 **Books Management** — Add, View, Edit, Delete books
- 👥 **Members Management** — Add, View, Edit, Delete members
- 🔍 Clean MVC architecture
- 💾 JDBC-based persistence with MySQL
- 🧩 Singleton pattern for DB connection
- 🧱 Layered architecture (Model → DAO → Service → Controller → View)

---

## 🏗️ Tech Stack

| Layer          | Technology                       |
| -------------- | -------------------------------- |
| **Frontend**   | JSP, JSTL, HTML, CSS             |
| **Controller** | Java Servlet (javax.servlet 4.0) |
| **Service**    | Plain Java (Business logic)      |
| **DAO**        | JDBC + PreparedStatement         |
| **Database**   | MySQL 8                          |
| **Build**      | Maven 3                          |
| **Server**     | Apache Tomcat 9                  |
| **IDE**        | Eclipse / IntelliJ               |

---

## 🧠 OOP Concepts Covered

| Concept               | Implementation                                       |
| --------------------- | ---------------------------------------------------- |
| **Encapsulation**     | Private fields + getters/setters in `Book`, `Member` |
| **Abstraction**       | DAO interfaces (`BookDAO`, `MemberDAO`)              |
| **Inheritance**       | Servlets extend `HttpServlet`                        |
| **Polymorphism**      | `BookDAOImpl` implements `BookDAO`                   |
| **Singleton Pattern** | `DBConnection.getInstance()`                         |

---

## 📁 Project Structure

library-management-system/
├── pom.xml
├── src/
│ └── main/
│ ├── java/com/library/
│ │ ├── controller/ # Servlets
│ │ ├── dao/ # DAO interfaces + impl
│ │ ├── model/ # Book, Member
│ │ ├── service/ # Business logic
│ │ └── util/ # DBConnection
│ └── webapp/
│ ├── WEB-INF/web.xml
│ ├── index.jsp
│ ├── book/ # Book JSPs
│ └── member/ # Member JSPs
└── README.md

---

## 🚀 How to Run Locally

### 1. Prerequisites

- JDK 11+
- Maven 3.6+
- MySQL 8+
- Tomcat 9 (⚠️ NOT Tomcat 10+, due to `javax.*` → `jakarta.*` rename)

### 2. Set Up Database

```sql
CREATE DATABASE library_db;
USE library_db;

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    category VARCHAR(100),
    quantity INT DEFAULT 1,
    available_quantity INT DEFAULT 1
);

CREATE TABLE members (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(255)
);
```
