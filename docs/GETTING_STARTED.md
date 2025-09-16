# Getting Started with EduRace Platform

## Prerequisites

### Required Software
- **Java 17+** - For Spring Boot backend
- **Node.js 18+** - For Next.js frontend
- **MySQL 8.0+** - Database
- **Git** - Version control

### Development Tools (Recommended)
- **IntelliJ IDEA** or **VS Code** - IDEs
- **Postman** or **Insomnia** - API testing
- **MySQL Workbench** - Database management

## Project Setup

### 1. Clone the Repository
```bash
git clone <your-repo-url>
cd edurace-platform
```

### 2. Database Setup

#### Create Database
```sql
CREATE DATABASE edurace_db;
```

#### Configure Environment Variables
Copy `.env.example` to `.env` and update the values:
```bash
cp .env.example .env
```

Update the database credentials:
```
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

#### Run Database Initialization (Optional)
```bash
mysql -u your_username -p edurace_db < database/init.sql
```

### 3. Backend Setup

#### Navigate to backend directory
```bash
cd backend
```

#### Install Dependencies & Run
```bash
# Using Maven
mvn clean install
mvn spring-boot:run

# Or using Maven Wrapper (if available)
./mvnw clean install
./mvnw spring-boot:run
```

Backend will start on: http://localhost:8080

### 4. Frontend Setup

#### Navigate to frontend directory
```bash
cd frontend
```

#### Install Dependencies
```bash
npm install
# or
yarn install
```

#### Configure Environment
```bash
cp .env.local.example .env.local
```

#### Start Development Server
```bash
npm run dev
# or
yarn dev
```

Frontend will start on: http://localhost:3000

## API Documentation

Once the backend is running, access the Swagger UI at:
http://localhost:8080/swagger-ui.html

## Default Admin Account

After running the database initialization script, you can login with:
- **Email**: admin@edurace.com
- **Password**: admin123 *(Change this in production!)*

## Project Structure

```
edurace-platform/
├── frontend/               # Next.js application
│   ├── src/
│   │   ├── app/           # App router pages
│   │   └── components/    # React components
│   └── public/            # Static assets
├── backend/               # Spring Boot application
│   ├── src/main/java/com/edurace/platform/
│   │   ├── entity/        # JPA entities
│   │   ├── repository/    # Data repositories
│   │   ├── service/       # Business logic
│   │   ├── controller/    # REST controllers
│   │   ├── config/        # Configuration classes
│   │   └── security/      # Security components
│   └── src/main/resources/
│       └── application.yml # Application configuration
├── database/              # Database scripts
└── docs/                  # Documentation
```

## Key Features to Implement

### Phase 1: Core Authentication
- [x] User registration/login
- [ ] Google OAuth integration
- [ ] Phone OTP verification
- [ ] Email verification

### Phase 2: Course Management
- [ ] Course creation (Instructors)
- [ ] Sequential lesson structure
- [ ] Quiz creation and management
- [ ] Content upload

### Phase 3: Gamification
- [ ] Points system
- [ ] Real-time leaderboards
- [ ] Achievement badges
- [ ] Daily streaks

### Phase 4: Payments & Rewards
- [ ] Razorpay/Stripe integration
- [ ] Course fees collection
- [ ] Prize pool distribution

### Phase 5: Proctoring
- [ ] Webcam monitoring
- [ ] Suspicious activity detection
- [ ] Activity logging

## Development Guidelines

### Backend Development
1. Follow Spring Boot best practices
2. Use proper exception handling
3. Implement proper logging
4. Write unit and integration tests
5. Use DTOs for API responses
6. Implement proper validation

### Frontend Development
1. Follow Next.js 14 App Router conventions
2. Use TypeScript for type safety
3. Implement proper error boundaries
4. Use Tailwind CSS for styling
5. Implement proper loading states
6. Handle authentication state properly

## Environment Configuration

### Backend Environment Variables
```yaml
# Database
DB_USERNAME=root
DB_PASSWORD=password

# JWT
JWT_SECRET=your-super-secret-jwt-key

# OAuth
GOOGLE_CLIENT_ID=your-google-client-id
GOOGLE_CLIENT_SECRET=your-google-client-secret

# Payments
RAZORPAY_KEY_ID=your-razorpay-key
RAZORPAY_KEY_SECRET=your-razorpay-secret

# SMS
TWILIO_ACCOUNT_SID=your-twilio-sid
TWILIO_AUTH_TOKEN=your-twilio-token
```

### Frontend Environment Variables
```env
NEXT_PUBLIC_API_URL=http://localhost:8080/api
NEXT_PUBLIC_WS_URL=ws://localhost:8080/ws
NEXT_PUBLIC_GOOGLE_CLIENT_ID=your-google-client-id
```

## Troubleshooting

### Common Issues

#### Database Connection Issues
- Ensure MySQL is running
- Check database credentials
- Verify database exists

#### Port Conflicts
- Backend default: 8080
- Frontend default: 3000
- Change ports in configuration if needed

#### CORS Issues
- Frontend and backend CORS is pre-configured
- Update `corsConfigurationSource()` in SecurityConfig if needed

## Next Steps

1. Set up your development environment
2. Configure all environment variables
3. Start with user authentication features
4. Implement course management
5. Add gamification features
6. Integrate payment systems
7. Implement proctoring features

## Support

For issues and questions:
1. Check this documentation
2. Review the code comments
3. Check the entity relationships
4. Use the API documentation (Swagger UI)

Happy coding! 🚀