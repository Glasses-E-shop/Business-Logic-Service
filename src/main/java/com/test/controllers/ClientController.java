package com.test.controllers;

import com.test.dto.AuthDTO;
import com.test.dto.ClientDTO;
import com.test.entities.Client;
import com.test.exceptions.InvalidInputException;
import com.test.exceptions.NotFoundException;
import com.test.servicies.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @GetMapping(path = "/getall/{passwd}")
    @ResponseBody
    public List<Client> getClients(@PathVariable(name="passwd") String passwd) throws NotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://auth:8080/api/v1/auth/authenticate";
        System.out.println("Connection Secured with auth server");
        HttpHeaders headers = new HttpHeaders();
        AuthDTO dto = new AuthDTO();
        dto.setPassword(passwd);
        dto.setEmail("admin");
        HttpEntity<AuthDTO> requestEntity = new HttpEntity<>(dto, headers);
        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response
                = restTemplate.postForEntity(resourceUrl,requestEntity,String.class);

        String productsJson = response.getBody();
        assert productsJson != null;
        if(productsJson.equals("Accepted"))
            return this.clientService.getClients();
        else
            return null;
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
