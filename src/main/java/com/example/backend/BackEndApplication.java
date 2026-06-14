package com.example.backend;

import com.example.backend.data.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    @Bean
    public CommandLineRunner run (ArchitectRepository architectRepository
            , ContractorRepository contractorRepository
            , ProjectManagerRepository projManagerRepository
            , CustomerRepository customerRepository
            , StructuralEngineerRepository structEngineerRepository
    ) {
        return args -> {
            architectRepository.findAll().forEach(
                    System.out::println
            );
            contractorRepository.findAll().forEach(
                    System.out::println
            );
            projManagerRepository.findAll().forEach(
                    System.out::println
            );
            customerRepository.findAll().forEach(
                    System.out::println
            );
            structEngineerRepository.findAll().forEach(
                    System.out::println
            );

        };
    }

}
