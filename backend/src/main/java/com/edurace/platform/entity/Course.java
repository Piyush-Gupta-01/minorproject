package com.edurace.platform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Course title is required")
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;
    
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    
    @DecimalMin(value = "0.0", message = "Entry fee must be non-negative")
    @Column(name = "entry_fee", precision = 10, scale = 2)
    private BigDecimal entryFee = BigDecimal.ZERO;
    
    @Min(value = 1, message = "Total lessons must be at least 1")
    @Column(name = "total_lessons", nullable = false)
    private Integer totalLessons;
    
    @Column(name = "estimated_duration_hours")
    private Integer estimatedDurationHours;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level")
    private DifficultyLevel difficultyLevel = DifficultyLevel.BEGINNER;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CourseStatus status = CourseStatus.DRAFT;
    
    @Column(name = "is_featured", nullable = false)
    private Boolean isFeatured = false;
    
    @Column(name = "max_enrollments")
    private Integer maxEnrollments;
    
    @Column(name = "enrollment_start_date")
    private LocalDateTime enrollmentStartDate;
    
    @Column(name = "enrollment_end_date")
    private LocalDateTime enrollmentEndDate;
    
    @Column(name = "course_start_date")
    private LocalDateTime courseStartDate;
    
    @Column(name = "course_end_date")
    private LocalDateTime courseEndDate;
    
    @Column(name = "total_prize_pool", precision = 10, scale = 2)
    private BigDecimal totalPrizePool = BigDecimal.ZERO;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sequenceOrder ASC")
    private List<Lesson> lessons;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Leaderboard> leaderboards;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Payment> payments;
    
    // Constructors
    public Course() {}
    
    public Course(String title, String description, User instructor, Integer totalLessons) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.totalLessons = totalLessons;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Lifecycle callbacks
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public User getInstructor() { return instructor; }
    public void setInstructor(User instructor) { this.instructor = instructor; }
    
    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    
    public BigDecimal getEntryFee() { return entryFee; }
    public void setEntryFee(BigDecimal entryFee) { this.entryFee = entryFee; }
    
    public Integer getTotalLessons() { return totalLessons; }
    public void setTotalLessons(Integer totalLessons) { this.totalLessons = totalLessons; }
    
    public Integer getEstimatedDurationHours() { return estimatedDurationHours; }
    public void setEstimatedDurationHours(Integer estimatedDurationHours) { this.estimatedDurationHours = estimatedDurationHours; }
    
    public DifficultyLevel getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) { this.difficultyLevel = difficultyLevel; }
    
    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }
    
    public Boolean getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Boolean isFeatured) { this.isFeatured = isFeatured; }
    
    public Integer getMaxEnrollments() { return maxEnrollments; }
    public void setMaxEnrollments(Integer maxEnrollments) { this.maxEnrollments = maxEnrollments; }
    
    public LocalDateTime getEnrollmentStartDate() { return enrollmentStartDate; }
    public void setEnrollmentStartDate(LocalDateTime enrollmentStartDate) { this.enrollmentStartDate = enrollmentStartDate; }
    
    public LocalDateTime getEnrollmentEndDate() { return enrollmentEndDate; }
    public void setEnrollmentEndDate(LocalDateTime enrollmentEndDate) { this.enrollmentEndDate = enrollmentEndDate; }
    
    public LocalDateTime getCourseStartDate() { return courseStartDate; }
    public void setCourseStartDate(LocalDateTime courseStartDate) { this.courseStartDate = courseStartDate; }
    
    public LocalDateTime getCourseEndDate() { return courseEndDate; }
    public void setCourseEndDate(LocalDateTime courseEndDate) { this.courseEndDate = courseEndDate; }
    
    public BigDecimal getTotalPrizePool() { return totalPrizePool; }
    public void setTotalPrizePool(BigDecimal totalPrizePool) { this.totalPrizePool = totalPrizePool; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public List<Lesson> getLessons() { return lessons; }
    public void setLessons(List<Lesson> lessons) { this.lessons = lessons; }
    
    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
    
    public List<Leaderboard> getLeaderboards() { return leaderboards; }
    public void setLeaderboards(List<Leaderboard> leaderboards) { this.leaderboards = leaderboards; }
    
    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }
    
    // Utility methods
    public void addToPrizePool(BigDecimal amount) {
        this.totalPrizePool = this.totalPrizePool.add(amount);
    }
    
    public boolean isEnrollmentOpen() {
        LocalDateTime now = LocalDateTime.now();
        return (enrollmentStartDate == null || now.isAfter(enrollmentStartDate)) &&
               (enrollmentEndDate == null || now.isBefore(enrollmentEndDate)) &&
               status == CourseStatus.PUBLISHED;
    }
    
    public boolean hasStarted() {
        return courseStartDate != null && LocalDateTime.now().isAfter(courseStartDate);
    }
    
    public boolean hasEnded() {
        return courseEndDate != null && LocalDateTime.now().isAfter(courseEndDate);
    }
}