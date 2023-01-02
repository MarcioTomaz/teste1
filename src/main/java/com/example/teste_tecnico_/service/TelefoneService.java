package com.example.teste_tecnico_.service;

import com.example.teste_tecnico_.entities.Telefone;
import com.example.teste_tecnico_.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository repository;

    @Transactional
    public Telefone save(Telefone telefone){

        if( telefone.getId() != null) {

            Telefone currentClient = telefone;
            Telefone editClient = new Telefone(telefone);

            repository.save(editClient);
        }else{
            repository.save(telefone);
        }

        return telefone;
    }

    public List<Telefone> findAllTelefonesByClientId(Long id) {
        List<Telefone> result = repository.findAllTelefonesByClientId(id);
        return result;
    }

    public Optional<Telefone> findById(Long id) {

        Optional<Telefone> result = repository.findById(id);

        return result;
    }

}
