package com.upiiz.examen2.repositories.RepositoriesSesion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.examen2.entities.EntitiesSesion.UsuarioEntity;;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    UsuarioEntity findByEmail(String email);
    
}
