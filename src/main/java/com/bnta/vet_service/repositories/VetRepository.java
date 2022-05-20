package com.bnta.vet_service.repositories;


import com.bnta.vet_service.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface VetRepository extends JpaRepository<Vet, Long> {
    }
