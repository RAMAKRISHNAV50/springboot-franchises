package com.example.franchise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
    // New method to find franchise by name for the dashboard
    Optional<Franchise> findByFranchiseName(String franchiseName);
}