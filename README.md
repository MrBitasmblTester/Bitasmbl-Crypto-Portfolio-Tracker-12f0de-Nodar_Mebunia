# Bitasmbl-Crypto-Portfolio-Tracker-12f0de-Nodar_Mebunia

## Description
Build a RESTful API that allows users to track their cryptocurrency investments by fetching live prices, calculating portfolio value, and recording transactions. This project focuses on building secure endpoints, data persistence, and integrating third-party APIs.

## Tech Stack
- Kotlin

## Requirements
- Persist user portfolios and transactions using a database
- Fetch live crypto data from public API (CoinGecko, Binance, etc.)
- Implement secure authentication using JWT or similar mechanism

## Installation
Follow these steps to set up the project locally.

1. Clone the repository

   git clone https://github.com/MrBitasmblTester/Crypto-Portfolio-Tracker.git
   cd Crypto-Portfolio-Tracker

2. Ensure the runtime and build tools are available

   - Install a recent JDK (11+). Example (Ubuntu):
     sudo apt-get update && sudo apt-get install -y openjdk-11-jdk

   - The project uses Gradle wrapper. No global Gradle install is required.

3. Build the project

   - On macOS/Linux:
     ./gradlew build

   - On Windows:
     gradlew.bat build

4. Environment variables

   The application typically requires environment variables for database connectivity, authentication secrets, and third-party API endpoints. Create a file named .env or export the variables in your shell. Example variables to set before running the service:

   - DATABASE_URL: JDBC connection string to your database (e.g., jdbc:postgresql://localhost:5432/crypto_db)
   - JWT_SECRET: secret key used to sign JWT tokens
   - COINGECKO_API_URL: base URL for CoinGecko API (optional, defaults to public CoinGecko endpoint)
   - PORT: port the application should listen on (e.g., 8080)

   Example .env content:

   DATABASE_URL=jdbc:postgresql://localhost:5432/crypto_db
   JWT_SECRET=your_jwt_secret_here
   COINGECKO_API_URL=https://api.coingecko.com/api/v3
   PORT=8080

5. Database setup

   - Create a database instance accessible via DATABASE_URL.
   - Apply any database schema/migrations used by the project (refer to the project's migration scripts or instructions, if present).

6. Install any required database server locally if needed (PostgreSQL, MySQL, etc.).

## Usage
Start and run the backend service. The minimal steps below assume environment variables are configured and a database is available.

1. Ensure environment variables are exported or .env is loaded.
2. Start the application using the Gradle wrapper:

   ./gradlew run

   or, if a runnable JAR is produced after build:

   java -jar build/libs/<your-artifact>.jar

3. By default the API will be available at http://localhost:8080 (or the PORT you configured).

4. Use the API to register users, authenticate (obtain JWT), create portfolios, record transactions, and request portfolio valuations which fetch live prices from configured public crypto APIs.

## Implementation Steps
1. Initialize a Kotlin project with Gradle (use the Gradle wrapper) and configure a main entry point for a REST server.
2. Add dependencies for: HTTP server framework (your choice), JSON serialization, JDBC driver for your chosen database, and JWT handling. Configure the build script accordingly.
3. Define data models:
   - User (id, email, password hash, createdAt)
   - Portfolio (id, userId, name, createdAt)
   - Transaction (id, portfolioId, cryptoSymbol, amount, priceAtTransaction, timestamp, type)
4. Configure database connectivity using DATABASE_URL and implement persistence for users, portfolios, and transactions (via JDBC or an ORM library).
5. Implement registration and authentication endpoints:
   - Hash and store user passwords securely.
   - Issue JWTs signed with JWT_SECRET on successful authentication.
   - Implement middleware to validate JWTs and protect secured endpoints.
6. Implement portfolio and transaction endpoints to allow creating, reading, and listing portfolios and transactions tied to authenticated users.
7. Integrate live price fetching:
   - Implement an HTTP client to call public APIs (CoinGecko, Binance, etc.) using configurable API base URLs.
   - Provide a service that returns current prices for requested crypto symbols.
8. Implement portfolio valuation logic that aggregates transactions, applies current prices, and returns portfolio value and per-asset breakdowns.
9. Add input validation, error handling, and appropriate HTTP response codes for all endpoints.
10. Build and run the application locally, then test endpoints with an HTTP client (curl, Postman) using registered user credentials and JWT tokens.
11. Package the application (build a runnable JAR) for deployment and document required environment variables and startup commands.

## API Endpoints (Optional)
- POST /auth/register — Register a new user
- POST /auth/login — Authenticate and receive a JWT
- GET /portfolios — List authenticated user's portfolios
- POST /portfolios — Create a new portfolio for the authenticated user
- GET /portfolios/{portfolioId} — Get details for a portfolio (including valuation)
- POST /portfolios/{portfolioId}/transactions — Record a transaction in a portfolio
- GET /transactions — List transactions for the authenticated user (or accept query parameters for filtering)
- GET /prices?symbols=BTC,ETH — Fetch live prices for requested crypto symbols from configured public API