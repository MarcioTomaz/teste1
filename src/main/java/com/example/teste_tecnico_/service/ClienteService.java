package com.example.teste_tecnico_.service;

import com.example.teste_tecnico_.entities.Cliente;
import com.example.teste_tecnico_.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){

        if( cliente.getId() != null) {

            Cliente currentClient = cliente;
            Cliente editClient = new Cliente(cliente);

            repository.save(editClient);
        }else{
            repository.save(cliente);
        }

        return cliente;
    }

    public List<Cliente> findAllClients() {
        List<Cliente> result = repository.findAll();
        return result;
    }

    public Optional<Cliente> findById(Long id) {

        Optional<Cliente> result = repository.findById(id);

        return result;
    }
}
