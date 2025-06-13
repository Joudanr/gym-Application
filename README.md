# gym-Application

## 📋 Overview

This project is a **Gym Membership Management System** built as a term project for the CS313: Advanced Programming Language course. It provides an interactive and intuitive interface for **Admins**, **Trainers**, and **Members** to manage, monitor, and participate in various gym-related operations. The system is implemented using JavaFX for GUI, Oracle Database for backend storage, and follows object-oriented design principles.

The application is divided into three main user views:
- **Admin View**: Includes user management (add/remove/update users), service management, and offer creation.
- **Trainer View**: Trainers can add, edit, and delete classes, as well as track member progress.
- **Member View**: Members can view upcoming classes, join a class, view and update profile details, and browse available offers.

> 🕒 **Challenge Note**:  
> This system was developed in just **two weeks**, during a period filled with exams and ongoing coursework. Despite the tight schedule and high pressure, our team worked with full dedication and managed to deliver a complete and functional application — a true accomplishment under intense academic load.


## 🎯 Key Features

### 👨‍💼 Admin Panel
- **User Management**: Add, update, or remove users (Members or Trainers).
- **Service Management**: View, add, and delete gym services.
- **Offer Management**: Create and manage discount coupons.
- **Security**: Role-based login with credentials (ID and Password).

### 🏋️ Trainer Panel
- **Session Control**: Add, edit, and remove training sessions.
- **Progress Tracking**: View and evaluate member progress using health metrics.
- **User Interface**: Responsive UI elements with validation.

### 🙋 Member Panel
- **View Profile**: Access and update personal profile information.
- **Class Participation**: Join one class and track upcoming sessions.
- **Offers**: Browse current promotions and offers.

## 🖼️ GUI Preview

The application uses FXML and a clean CSS stylesheet for consistent and modern design. Some interfaces include:

- Login Screen
- Admin Dashboard with user/service/offer management
- Trainer Dashboard with session and progress tools
- Member Dashboard with class booking and profile settings

(*See screenshots in the documentation for details*)

## 🗃️ Database Schema

The system uses Oracle DB and contains the following key tables:

- `useerss_`: Stores user data (ID, email, role, etc.)
- `Classes__`: Stores training session info
- `services`: Stores offered gym services
- `Offer`: Stores discount information
- `traProgres__`: Stores member fitness tracking records

## 🔌 Tech Stack

- **Frontend**: JavaFX, FXML, CSS
- **Backend**: Java
- **Database**: Oracle SQL (JDBC driver)
- **IDE**: NetBeans

## ⚙️ How to Run

1. **Set up Oracle DB** and import the provided schema.
2. Configure the database connection in `DataBaseConnection.java`:
   ```java
   private static final String db_url = "jdbc:oracle:thin:@<your-ip>:<port>:<sid>";
   private static final String db_user = "your_db_user";
   private static final String db_pass = "your_db_pass";
