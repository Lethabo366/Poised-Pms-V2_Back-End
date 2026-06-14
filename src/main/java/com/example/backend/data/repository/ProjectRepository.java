package com.example.backend.data.repository;

import com.example.backend.data.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer> {

    List<ProjectEntity> findByArchitectArchitectId(
            Integer architectId);

    List<ProjectEntity> findByCustomerCustomerId(
            Integer customerId);

    List<ProjectEntity> findByContractorContractorId(
            Integer contractorId);

    List<ProjectEntity> findByProjectManagerProjectManagerId(
            Integer projectManagerId);

    List<ProjectEntity> findByStructuralEngineerStructEngineerId(
            Integer structEngineerId);
}
