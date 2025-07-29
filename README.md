Project Management Backend

📌 Project Overview

This repository contains the backend for the Project Management application, designed to handle task management, project tracking, and team collaboration. The system supports CRUD operations for projects, tasks, and user management with secure authentication.

> Note: This project also includes a frontend implementation that interacts with this backend to provide a full-stack solution.




---

🚀 Features

User registration and authentication (JWT-based)

Project and task creation, updating, and deletion

Role-based access control (Admin, User)

RESTful API endpoints for project management

Database integration with robust schema design

Error handling and logging

Integration-ready for frontend client



---

🛠 Tech Stack

Backend Framework: Node.js / Express.js

Database: MongoDB (Mongoose ORM)

Authentication: JWT (JSON Web Tokens)

Environment Management: dotenv

Other: bcrypt for password hashing, middleware for request validation



---

⚙️ Installation

Clone the repository and install dependencies:

# Clone the repository
git clone https://github.com/MatinAfrashteh/ProjectManagment.git

# Navigate to backend directory
cd ProjectManagment/backend

# Install dependencies
npm install


---

🔑 Configuration

Create a .env file in the backend directory with the following variables:

PORT=5000
MONGO_URI=your_mongodb_connection_string
JWT_SECRET=your_secret_key


---

▶️ Running the Server

Start the server in development mode:

npm run dev

Or production mode:

npm start

Server will run on http://localhost:5000 by default.


---

📚 API Documentation

POST /api/auth/register – Register a new user

POST /api/auth/login – User login

GET /api/projects – Retrieve all projects

POST /api/projects – Create a new project

PUT /api/projects/:id – Update a project

DELETE /api/projects/:id – Delete a project

GET /api/tasks – Retrieve all tasks

POST /api/tasks – Create a new task

... (additional endpoints can be added as needed)



---

🖥 Frontend

The frontend of this project is located in a separate directory and communicates with this backend via RESTful API. It provides a user-friendly interface for project and task management.


---

🤝 Contribution Guide

1. Fork the repository


2. Create a new branch (git checkout -b feature-name)


3. Commit your changes (git commit -m 'Add new feature')


4. Push to your branch (git push origin feature-name)


5. Open a Pull Request
