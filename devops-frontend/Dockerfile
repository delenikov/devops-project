# Base image
FROM node:17-alpine as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the working directory
COPY package*.json ./

# Install dependencies
RUN npm ci --quiet

# Copy the entire application code to the working directory
COPY . .

# Build the production-ready React app
RUN npm run build

# Install serve globally to run the app
RUN npm install -g serve

EXPOSE 3000

# Set the command to run when the container starts
CMD ["npx", "serve", "build"]

