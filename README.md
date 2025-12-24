# Video Game DB Manager with GUI (Program Design 2)

A desktop application for managing a video game database with a graphical user interface. This tool allows users to create, read, update, and delete records of video games stored in a local database — all through an intuitive Java GUI.

---

## Overview

This project is a Java-based application built with a GUI that connects to a database to let users manage a collection of video games. Instead of typing SQL queries, users interact through buttons, forms, and tables to view and organize their game library.

It’s a great way to learn working with databases in Java, GUI frameworks, and how to structure a simple CRUD (Create, Read, Update, Delete) application.

---

## Features

- Add new video games to the database  
- Edit existing game entries  
- Delete games you no longer want in the list  
- Browse and filter games from within the GUI

---

## Technology Stack

This project uses:

- **Java** (core language)  
- A GUI toolkit (check your code for specifics: likely Swing or JavaFX)  
- A local database (e.g., embedded or external — see setup below)  
- Maven for project management and building

---

## Getting Started

### Prerequisites

Before running the app, make sure you have:

- Java JDK installed (version 8 or above)
- Maven installed
- A database (e.g., SQLite, MySQL) accessible from your system

### Installation & Running

1. Clone this repository:

   ```bash
   git clone https://github.com/NovaS007/video-game-db-manager-with-gui.git
   ```

2. Enter the project directory:

   ```bash
   cd video-game-db-manager-with-gui
   ```

3. Build with Maven:

   ```bash
   mvn clean install
   ```

4. Run the app:

   ```bash
   mvn exec:java
   ```

   (Depending on your setup, you might run a main class directly in your IDE.)

## Project Structure

Here is the general structure of the repo:
```bash
├── src/
│   └── main/               # Java source code
│       ├── java/           # Core application logic
│       └── resources/      # GUI layouts, database scripts, etc.
├── .gitignore              # Files to ignore in Git
├── pom.xml                 # Maven config
├── LICENSE                 # MIT License
```
