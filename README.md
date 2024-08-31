# Music-Play-Application
This project is a fullstack application that allows users to search for and listen to music previews by searching for artists. It integrates with the iTunes API to provide music data and previews. Additionally, it provides backend services for user management and storing favorited songs.

## Tools used
Java | Spring Boot | PostgreSQL | Docker | React | Vite | Javascript | CSS 

## Installation Locally
### Prerequisites
- Docker installed on your machine.
### Setup
- Navigate to the app directory:
```bash
cd app/
```  
- Build the Docker image and start the containers:
```bash
docker compose up -d --build
```
This command will build the Docker images defined in docker-compose.yml and start the MySQL database and Spring Boot application containers.

### Database Configuration
- PostgreSQL is used as the database for this application.
- The database connection URL is set in application.properties.

### Accessing the Application Locally
Once both backend and frontend are running, you can access the application in your browser: http://localhost:5173

## Deployment
The application is deployed and accessible at the following link: [Music Play.](https://music-play-fullstack.vercel.app/)
Please note that since this application is hosted on a free plan, it may take a minute to become fully responsive upon your first interaction. This delay is due to the server's initial startup time.
### Hosting Details
Frontend: The frontend of the application is hosted on Vercel.
Backend: The backend of the application is hosted on Render.
Database: The MySQL database is hosted on Neon.