package com.example.backend.data.repository;


import com.example.backend.data.entity.ContractorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<ContractorEntity,Integer> {

}
