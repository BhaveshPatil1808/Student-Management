# 🎓 Spring ORM Student Management

[![Java](https://img.shields.io/badge/Java-1.8-blue?logo=java)](https://www.oracle.com/java/)
[![JPA](https://img.shields.io/badge/JPA-2.2-green)](https://jakarta.ee/specifications/persistence/)
[![EclipseLink](https://img.shields.io/badge/EclipseLink-2.7.12-orange)](https://www.eclipse.org/eclipselink/)
[![Database](https://img.shields.io/badge/Database-MySQL-lightblue?logo=mysql)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red?logo=apache-maven)](https://maven.apache.org/)

A **console-based Student Management System** built with **Spring ORM (JPA + EclipseLink)** and **MySQL**.  
It demonstrates CRUD operations (`Create`, `Read`, `Update`, `Delete`) using **EntityManager** and persistence configuration.

---

## 🛠 Tech Stack
- ☕ **Java 1.8**
- 📦 **Maven** (dependency management)
- 🔗 **JPA 2.2** (Java Persistence API)
- 🌐 **EclipseLink 2.7.12** (JPA provider)
- 🗄 **MySQL Database**
- 🖥 **Console-based UI**

---

## 📦 Features
- ➕ **Save Student** (persist new student record)  
- 🔍 **Find Student** (retrieve by ID)  
- ✏️ **Update Student** (modify existing record)  
- ❌ **Delete Student** (remove record by ID)  
- 📜 **Menu-driven CLI** for user interaction  

---

## ⚙️ Prerequisites
- Java 1.8+  
- MySQL running locally  
- Maven installed  
- EclipseLink dependency configured  

---

## 🚀 Getting Started

1️⃣ **Clone the repository**
```bash
git clone https://github.com/BhaveshPatil1808/SpringOrm.git
cd SpringOrm
```

---
## 2️⃣ Configure Database  
Update persistence.xml with your DB credentials:
```
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             version="2.2"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">

    <persistence-unit name="Student">

        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>

        <class>com.SpringOrm.Entity.Student</class>

        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/student"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="yourPassword"/>

            <property name="eclipselink.logging.level" value="SEVERE"/>
            <property name="eclipselink.ddl-generation" value="create-or-extend-tables"/>
        </properties>

    </persistence-unit>

</persistence>
```
---

## 3️⃣ Create Database Schema
Due to Hibernate ORM the table will be created Automaticaly.

---

## 4️⃣ Build the project
```
mvn clean install
```

---

---
## 5️⃣ Run the application
```
mvn exec:java -Dexec.mainClass="com.SpringOrm.App"
```

---

## 💬 Usage (CLI Flow)
**📖 Menu Options**
Save Student

Find Student

Update Student

Delete Student

Exit

---

## 📂 Project Structure
```
SpringOrm/
 ├── src/main/java/com.SpringOrm/         # App.java (main class with menu)
 ├── src/main/java/com.SpringOrm.Entity/  # Student entity
 ├── src/main/resources/META-INF/         # persistence.xml (JPA config)
 ├── pom.xml                              # Maven dependencies
 └── target/                              # Compiled classes

```

---

## 🚀 Future Improvements
🌐 Add web-based UI (Spring Boot + Thymeleaf)

🔐 Add validation and exception handling

📊 Extend schema with multiple entities (Courses, Teachers)

🐳 Dockerize for deployment

📱 Integrate REST APIs for external access

---

## 👨‍💻 Author
**Bhavesh Patil**
