# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Architecture

EduRace Platform is a gamified e-learning platform with a microservice-like monorepo structure:

### Technology Stack
- **Frontend**: Next.js 15 with TypeScript, Tailwind CSS 4, React 19
- **Backend**: Spring Boot 3.2 with Java 17, Spring Security, JPA/Hibernate
- **Database**: MySQL 8.0+ with optimized indexing and triggers
- **Real-time**: WebSockets for live updates and competition features
- **External Services**: Razorpay/Stripe (payments), Google OAuth, Twilio (SMS/OTP)

### Key Architectural Components

#### Authentication & Authorization
- Multi-layered authentication: Email/Password, Google OAuth, Phone OTP
- JWT with HTTP-only cookies for session management
- Role-based access control: STUDENT, INSTRUCTOR, ADMIN
- Spring Security configuration with OAuth2 integration

#### Core Learning Engine
- **Sequential Learning**: Courses with locked lessons that unlock progressively
- **Quiz-Gated Progression**: Students must pass quizzes to unlock next lessons
- **Content Management**: Structured lesson content with multimedia support
- **Progress Tracking**: Completion percentages and performance analytics

#### Gamification System
- **Real-time Leaderboards**: Per-course rankings updated via WebSockets
- **Points System**: Performance and speed-based scoring
- **Achievement Engine**: Daily streaks and milestone badges
- **Competition Features**: Live updates during quiz sessions

#### Payment & Reward Architecture
- Course entry fees with automated prize pool creation
- Reward distribution to top performers based on leaderboard positions
- Integration with multiple payment providers (Razorpay/Stripe)
- Transaction logging and financial reconciliation

#### Proctoring System
- Webcam access and monitoring during quiz sessions
- Suspicious behavior detection algorithms
- Activity logging and integrity verification
- Real-time flagging system

## Common Development Commands

### Frontend (Next.js)
```bash
cd frontend

# Development with Turbopack
npm run dev

# Production build with Turbopack optimization
npm run build
npm run start

# Linting
npm run lint

# Install dependencies
npm install
```

### Backend (Spring Boot)
```bash
cd backend

# Development with hot reload
mvn spring-boot:run

# Production build
mvn clean install

# Run tests
mvn test

# Run specific test
mvn test -Dtest=ClassName

# Clean and rebuild
mvn clean compile
```

### Database Operations
```bash
# Initialize database with sample data
mysql -u username -p edurace_db < database/init.sql

# Connect to database
mysql -u username -p edurace_db
```

## Development Environment Setup

### Prerequisites
- Java 17+ (for Spring Boot backend)
- Node.js 18+ (for Next.js frontend) 
- MySQL 8.0+ (database)

### Environment Configuration

#### Backend Environment Variables (.env or application.yml)
```yaml
# Database
DB_USERNAME: root
DB_PASSWORD: password

# JWT Security
JWT_SECRET: your-super-secret-jwt-key

# OAuth Integration
GOOGLE_CLIENT_ID: your-google-client-id
GOOGLE_CLIENT_SECRET: your-google-client-secret

# Payment Providers
RAZORPAY_KEY_ID: your-razorpay-key
RAZORPAY_KEY_SECRET: your-razorpay-secret

# SMS/OTP Service
TWILIO_ACCOUNT_SID: your-twilio-sid
TWILIO_AUTH_TOKEN: your-twilio-token
```

#### Frontend Environment Variables (.env.local)
```env
NEXT_PUBLIC_API_URL=http://localhost:8080/api
NEXT_PUBLIC_WS_URL=ws://localhost:8080/ws
NEXT_PUBLIC_GOOGLE_CLIENT_ID=your-google-client-id
```

### Default Ports
- Frontend: http://localhost:3000
- Backend: http://localhost:8080
- API Documentation: http://localhost:8080/swagger-ui.html

## Project Structure & Key Directories

```
edurace-platform/
├── frontend/                    # Next.js 15 with App Router
│   ├── src/app/                # App Router pages and layouts
│   ├── src/components/         # Reusable React components
│   └── public/                 # Static assets
├── backend/                     # Spring Boot application
│   └── src/main/java/com/edurace/platform/
│       ├── entity/             # JPA entities (User, Course, Lesson, Quiz, etc.)
│       ├── repository/         # Spring Data JPA repositories
│       ├── service/            # Business logic layer
│       ├── controller/         # REST API endpoints
│       ├── config/             # Spring configuration classes
│       └── security/           # Authentication and authorization
├── database/                    # MySQL schemas, indexes, and initialization scripts
└── docs/                       # Project documentation
```

## Data Architecture

### Core Entities & Relationships
- **Users**: Multi-role system (STUDENT, INSTRUCTOR, ADMIN) with OAuth support
- **Courses**: Created by instructors with entry fees and sequential structure
- **Lessons**: Ordered content within courses with unlock progression
- **Quizzes**: Time-limited assessments with passing score requirements
- **Enrollments**: Student-course relationships with progress tracking
- **Leaderboard**: Real-time ranking system per course
- **Payments**: Transaction history and prize distribution records

### Database Optimizations
- Indexed relationships for performance (user email, course instructor, enrollments)
- Automatic timestamp triggers for audit trails
- Event scheduler enabled for background tasks
- Foreign key constraints for data integrity

## Development Guidelines

### Backend Development Patterns
- Follow Spring Boot best practices with proper layer separation
- Use DTOs for API request/response to avoid entity exposure
- Implement comprehensive exception handling with custom exceptions
- Use Spring Data JPA for repository layer with custom queries when needed
- JWT token management with secure HTTP-only cookies
- WebSocket endpoints for real-time gamification features

### Frontend Development Patterns  
- Follow Next.js 15 App Router conventions with TypeScript
- Use Tailwind CSS 4 for consistent styling
- Implement proper error boundaries and loading states
- Handle authentication state with proper token management
- Real-time updates via WebSocket connections
- Responsive design for mobile-first approach

### Testing Strategy
- Backend: Unit tests with JUnit, integration tests with Spring Boot Test
- Frontend: Component testing and E2E testing for critical user flows
- Database: Test data seeding and rollback strategies
- API: Comprehensive endpoint testing with various authentication scenarios

## Real-time Features Implementation

### WebSocket Architecture
- Course-specific channels for leaderboard updates
- Quiz session management with live participant tracking  
- Achievement notifications broadcast to relevant users
- Connection management with authentication verification

### State Management
- Frontend state synchronization with backend via WebSocket events
- Optimistic updates with fallback handling
- Real-time leaderboard updates during active quiz sessions