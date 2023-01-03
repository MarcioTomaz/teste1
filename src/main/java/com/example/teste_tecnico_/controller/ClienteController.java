package com.example.teste_tecnico_.controller;

import com.example.teste_tecnico_.entities.Cliente;
import com.example.teste_tecnico_.entities.Telefone;
import com.example.teste_tecnico_.service.ClienteService;
import com.example.teste_tecnico_.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    TelefoneService telefoneService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/createClient")
    public ModelAndView createClient(){
        ModelAndView mv = new ModelAndView("createClient");
        mv.addObject("cliente", new Cliente());

        return mv;
    }

    @PostMapping("/create")
    public String createClient(Cliente cliente){

        clienteService.save(cliente);

        return "redirect:/listClient";
    }

    @GetMapping("/editClient/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("editClient");

        Optional<Cliente> editClient = clienteService.findById(id);
        List<Telefone> phones = telefoneService.findAllTelefonesByClientId(id);

        mv.addObject("cliente", editClient.get());
        mv.addObject("telefones", phones);

        return mv;
    }

    @PostMapping("/editClient")
    public String editClient(Cliente cliente){

        clienteService.save(cliente);

        return "redirect:/listClient";
    }

    @GetMapping("/listClient")
    public ModelAndView list(){
        List<Cliente> result = clienteService.findAllClients();
        ModelAndView mv = new ModelAndView();
        mv.addObject("clientes", result);

        return mv;
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id") Long id){

        clienteService.delete(id);

        return "redirect:/listClient";
    }

}
