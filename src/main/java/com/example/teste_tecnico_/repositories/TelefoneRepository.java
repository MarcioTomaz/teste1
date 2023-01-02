package com.example.teste_tecnico_.repositories;

import com.example.teste_tecnico_.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM telefone WHERE id_client = :id")
    List<Telefone> findAllTelefonesByClientId(@Param("id") Long id);

}
