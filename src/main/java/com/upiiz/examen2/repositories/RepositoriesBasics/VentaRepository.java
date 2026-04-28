package com.upiiz.examen2.repositories.RepositoriesBasics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.examen2.entities.EntitiesBasics.VentasEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentasEntity, Long> {
    
}