# App Management System

## Building the Application

### Backend

1. Navigate to the backend directory:

    ```bash
    cd backend
    ```

2. Build the backend application:

    ```bash
    ./gradlew build
    ```

   This will generate a valid .jar file necessary for the Docker container.

### Frontend

The frontend application does not require a separate build process as it will be built when the Docker container is created.

## Deployment

### Deploying with Docker Compose

Ensure you have both [Docker](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/) installed on your system before proceeding.

Run the following command in the root directory to deploy both the frontend (accessible locally on port 80) and backend (accessible locally on port 8080):

```bash
docker-compose up -d
