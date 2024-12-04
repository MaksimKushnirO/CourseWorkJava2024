package com.example.coursework.repository;

import com.example.coursework.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach,Long> {
}
