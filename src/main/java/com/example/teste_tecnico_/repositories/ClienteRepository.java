package com.example.teste_tecnico_.repositories;

import com.example.teste_tecnico_.entities.Cliente;
import com.teste_tecnico.testetecnico.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
