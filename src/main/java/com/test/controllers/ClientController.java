package com.test.controllers;

import com.test.dto.ClientDTO;
import com.test.entities.Client;
import com.test.exceptions.InvalidInputException;
import com.test.exceptions.NotFoundException;
import com.test.servicies.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseBody
    public ClientDTO addClient(@RequestBody ClientDTO c) throws InvalidInputException {
        Client nou = this.clientService.add(c);
        return c;
    }
    @GetMapping
    @ResponseBody
    public List<Client> getClients() throws NotFoundException {
        return this.clientService.getClients();
    }
    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Client> getClient(@PathVariable(name="id") int id) throws NotFoundException {
        return this.clientService.getClient(id);
    }
    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delClient(@PathVariable(name="id") int id) {
        this.clientService.delClient(id);
        return "Deleted client with id: " + id;
    }
}
