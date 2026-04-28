package com.upiiz.examen2.repositories.RepositoriesBasics;

import org.springframework.stereotype.Repository;

import com.upiiz.examen2.entities.EntitiesBasics.VentasEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ventasRepositorie extends JpaRepository<VentasEntity, Long> {
    
}
