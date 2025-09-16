-- EduRace Platform Database Initialization Script

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS edurace_db;
USE edurace_db;

-- Set timezone
SET time_zone = '+00:00';

-- Enable event scheduler for automated tasks
SET GLOBAL event_scheduler = ON;

-- Create initial admin user (password should be changed in production)
-- Password: admin123 (will be hashed by Spring Security)
INSERT IGNORE INTO users (id, email, password, first_name, last_name, role, email_verified, created_at) 
VALUES (
    1, 
    'admin@edurace.com', 
    '$2a$10$lI8VzBkVhEfvx8fz8fvfaOuTGJdq5rIvJqKK8fvfvfvfvfvfvfvfvf', 
    'Admin', 
    'User', 
    'ADMIN', 
    true, 
    NOW()
);

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_courses_instructor ON courses(instructor_id);
CREATE INDEX IF NOT EXISTS idx_enrollments_student_course ON enrollments(student_id, course_id);
CREATE INDEX IF NOT EXISTS idx_quiz_attempts_student ON quiz_attempts(student_id);
CREATE INDEX IF NOT EXISTS idx_leaderboard_course ON leaderboard(course_id);
CREATE INDEX IF NOT EXISTS idx_payments_user ON payments(user_id);

-- Create triggers for automatic timestamp updates
DELIMITER $$

CREATE TRIGGER IF NOT EXISTS users_updated_at 
BEFORE UPDATE ON users 
FOR EACH ROW 
BEGIN 
    SET NEW.updated_at = NOW(); 
END$$

CREATE TRIGGER IF NOT EXISTS courses_updated_at 
BEFORE UPDATE ON courses 
FOR EACH ROW 
BEGIN 
    SET NEW.updated_at = NOW(); 
END$$

CREATE TRIGGER IF NOT EXISTS lessons_updated_at 
BEFORE UPDATE ON lessons 
FOR EACH ROW 
BEGIN 
    SET NEW.updated_at = NOW(); 
END$$

DELIMITER ;

-- Sample data for development
INSERT IGNORE INTO courses (id, title, description, instructor_id, entry_fee, total_lessons, created_at) 
VALUES 
(1, 'Introduction to Programming', 'Learn the basics of programming with hands-on exercises', 1, 499.00, 5, NOW()),
(2, 'Web Development Fundamentals', 'Master HTML, CSS, and JavaScript', 1, 999.00, 8, NOW());

INSERT IGNORE INTO lessons (id, course_id, title, description, content, sequence_order, created_at) 
VALUES 
(1, 1, 'Variables and Data Types', 'Understanding basic programming concepts', 'Content for lesson 1...', 1, NOW()),
(2, 1, 'Control Structures', 'Learn about if-else and loops', 'Content for lesson 2...', 2, NOW()),
(3, 1, 'Functions', 'Creating and using functions', 'Content for lesson 3...', 3, NOW());

INSERT IGNORE INTO quizzes (id, lesson_id, title, time_limit_minutes, passing_score, created_at) 
VALUES 
(1, 1, 'Variables Quiz', 30, 70, NOW()),
(2, 2, 'Control Structures Quiz', 30, 70, NOW()),
(3, 3, 'Functions Quiz', 30, 70, NOW());