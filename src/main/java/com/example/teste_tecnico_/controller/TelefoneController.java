package com.example.teste_tecnico_.controller;

import com.example.teste_tecnico_.DTO.CreateTelefoneDTO;
import com.example.teste_tecnico_.entities.Cliente;
import com.example.teste_tecnico_.entities.Telefone;
import com.example.teste_tecnico_.repositories.TelefoneRepository;
import com.example.teste_tecnico_.service.ClienteService;
import com.example.teste_tecnico_.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TelefoneController {

    @Autowired
    TelefoneService telefoneService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TelefoneRepository telefoneRepository;


    @GetMapping("/createTelefone/{id}")
    public ModelAndView createHome(){
        ModelAndView mv = new ModelAndView("createTelefone");
        mv.addObject("telefones", new Telefone());
//        mv.addObject("clienteId", clientId);

        return mv;
    }

    @PostMapping("/createTelefone")
    public String createClient(Telefone telefone){

        telefone.setCliente(new Cliente(5L));

        telefoneService.save(telefone);

        return "redirect:/listClient";
    }

    @GetMapping("/editTelefone/{id}")
    public ModelAndView editTelefone(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("editTelefone");

        Telefone editTelefone = telefoneService.findById(id).get();
        mv.addObject("telefones", editTelefone);

        return mv;
    }

    @PostMapping("/editTelefone")
    public String editClient(Telefone telefone){

        Telefone telefone1 = new Telefone(telefone);
        telefone1.setCliente(new Cliente(5L));

        telefoneService.save(telefone1);

        return "redirect:/listClient";
    }


    @GetMapping("/deleteTelefone/{id}")
    public String deleteClient(@PathVariable("id") Long id){

        telefoneService.delete(id);

        return "redirect:/listClient";
    }

}
