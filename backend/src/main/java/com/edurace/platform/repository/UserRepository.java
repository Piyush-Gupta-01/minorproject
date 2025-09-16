package com.edurace.platform.repository;

import com.edurace.platform.entity.User;
import com.edurace.platform.entity.AuthProvider;
import com.edurace.platform.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByPhoneNumber(String phoneNumber);
    
    Optional<User> findByProviderAndProviderId(AuthProvider provider, String providerId);
    
    List<User> findByRole(Role role);
    
    boolean existsByEmail(String email);
    
    boolean existsByPhoneNumber(String phoneNumber);
    
    @Query("SELECT u FROM User u WHERE u.emailVerified = true AND u.accountEnabled = true")
    List<User> findActiveUsers();
    
    @Query("SELECT u FROM User u WHERE u.role = :role AND u.emailVerified = true AND u.accountEnabled = true")
    List<User> findActiveUsersByRole(@Param("role") Role role);
    
    @Query("SELECT COUNT(u) FROM User u WHERE u.role = :role")
    Long countByRole(@Param("role") Role role);
    
    @Query("SELECT u FROM User u WHERE u.totalPoints > 0 ORDER BY u.totalPoints DESC")
    List<User> findTopUsersByPoints();
}