package com.example.backend.data.repository;

import com.example.backend.data.entity.ProjectManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepository extends JpaRepository<ProjectManagerEntity,Integer> {

}
