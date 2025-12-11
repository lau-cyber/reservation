# 📘 Classroom Reservation System

A web-based classroom reservation system designed for **XJTLU campus**, addressing the lack of an online platform for booking available classrooms for self-study.  
Students can search classrooms, join waiting lists, and reserve rooms online, reducing conflicts and improving space utilization.  
This system is built with **Spring Boot (Java)**, **MVC architecture**, and a **MySQL relational database**.

---

## 🚀 Features

### ✔ User Module
- User registration & login  
- Personal information management  

### ✔ Classroom Module
- View spare classrooms across campus  
- Search and filter rooms  
- View room capacity & availability  

### ✔ Reservation Workflow
- Add a room to the waiting list  
- Reserve classroom using generated **CID**  
- Modify reservation by deleting & rebuilding the request  

### ✔ Admin / Backend Support
- Database-driven room information  
- Persistent user & reservation data  

---

## 🧱 System Architecture

The system adopts a **four-layer architecture**:

```
┌──────────────────────────────┐
│  Visit Layer (UI Layer)      │ → JSP / HTML views
├──────────────────────────────┤
│  Access Layer (Controller)   │ → MVC controllers handle routing
├──────────────────────────────┤
│  Service Layer (Business)    │ → Reservation logic, validation
├──────────────────────────────┤
│  Data Layer (DAO + MySQL)    │ → Database operations
└──────────────────────────────┘
```


---

## 🗄 Database Design

Based on the ER diagram & relational schema

### **Main Tables**
- `t_user` — user accounts  
- `t_information` — personal details  
- `t_room` — classroom information  
- `t_cart` — waiting list entries  
- `t_order` — confirmed reservations  

All tables follow **3rd Normal Form (3NF)** to avoid data redundancy and ensure consistency.

---

## 📦 Installation & Setup

### **1. Database Setup**
- Run the SQL scripts in `/sql` to create tables and insert sample data.  
- Ensure MySQL connection settings in `application.properties` are correct.

### **2. Run the Application**
Run the main application file:

```src/main/java/com/cpt202a19/reservation/ReservationApplication.java```

### **3. Access in Browser**

```http://<your-ip-address>:8080```

---

## 🕹 User Instructions

1. Register your account  
2. Log in  
3. Browse classrooms  
4. Add a room to your waiting list  
5. Reserve rooms using the URL containing the generated **CID**  
6. To modify reservations → delete the original and recreate it  

*(Aligned with Report pp. 3–4 — CPT202 Assignment 2 - 1930115)*

---

## 🤝 Contribution Guidelines

1. Fork this repository  
2. Create a new branch: `feat_xxx`  
3. Commit your changes  
4. Submit a Pull Request  

---

