package com.portfolio.backend.repository;

import com.portfolio.backend.model.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{
    public Optional<Education> findByTitle (String title);
    public boolean existsByTitle (String title);
}
