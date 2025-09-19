# EduRace Platform

A gamified e-learning platform that combines sequential learning with real-time competition and rewards.

## 🎯 Project Overview

EduRace is a comprehensive e-learning platform that gamifies the learning experience through:
- **Sequential Learning**: Courses with locked lessons that unlock as students progress
- **Real-time Competition**: Live leaderboards and point systems
- **Gamification**: Daily streaks, achievement badges, and rewards
- **Multi-Authentication**: Email/Password, Google OAuth, and Phone OTP
- **Proctoring**: Webcam monitoring during quizzes
- **Payment Integration**: Course fees and prize distribution

## 🛠 Tech Stack

### Frontend
- **Next.js** with TypeScript
- **Tailwind CSS** for styling
- **WebSockets** for real-time updates

### Backend
- **Java Spring Boot**
- **Spring Security** for authentication
- **JPA/Hibernate** for data persistence
- **WebSockets** for real-time communication

### Database
- **MySQL** for primary data storage

### External Integrations
- **Razorpay/Stripe** for payments
- **Google OAuth** for authentication
- **SMS Service** for OTP

## 🎮 Core Features

### Multi-Authentication System
- Email/Password registration and login
- Google OAuth integration
- Phone number OTP verification
- JWT-based session management with HTTP-only cookies
- Role-based access control (STUDENT, INSTRUCTOR, ADMIN)

### Sequential Learning Module
- Courses with sequential lesson structure
- Quiz-gated progression (lessons unlock after passing previous quiz)
- Timed quizzes with defined passing scores
- Progress tracking and completion percentages

### Gamification Engine
- Real-time leaderboards per course
- Point system based on performance and speed
- Daily streak tracking
- Achievement badge system
- Live updates via WebSockets

### Payment & Reward System
- Optional course entry fees
- Automatic prize pool creation
- Reward distribution to top performers
- Secure payment processing

### Proctoring System
- Webcam access during quizzes
- Suspicious behavior detection
- Activity logging and flagging
- Integrity monitoring

### Student Dashboard
- Enrolled courses overview
- Progress tracking
- Points and badges display
- Performance analytics

## 📁 Project Structure

```
edurace-platform/
├── frontend/          # Next.js TypeScript application
├── backend/           # Spring Boot Java application
├── database/          # MySQL scripts and migrations
└── docs/             # Project documentation
```

## 🚀 Getting Started

*Setup instructions will be added as the project develops*

## 👥 User Roles

- **STUDENT**: Enroll in courses, take quizzes, compete on leaderboards
- **INSTRUCTOR**: Create courses, manage content, monitor student progress  
- **ADMIN**: Platform management, user administration, system oversight

## 📝 License

*License information to be added*# minorproject
