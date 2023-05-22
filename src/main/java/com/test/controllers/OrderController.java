package com.test.controllers;


import com.test.dto.OrderDTO;
import com.test.entities.Order_entity;
import com.test.servicies.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseBody
    public OrderDTO add(@RequestBody OrderDTO dto) {
        Order_entity nou = this.orderService.add(dto);
        return dto;
    }
    @GetMapping
    @ResponseBody
    public List<Order_entity> get() {
        return this.orderService.get();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Order_entity> getById(@PathVariable(name="id") int id) {
        return this.orderService.getById(id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") int id) {
        this.orderService.delete(id);
        return "Cancelled order with id: " + id;
    }

    @PostMapping("/email-confirmation")
    @ResponseBody
    public ResponseEntity<String> postEmailConfirmation() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> emailMessage = new HashMap<>();
        emailMessage.put("to", "recipient@example.com");
        emailMessage.put("subject", "Order Confirmation");
        emailMessage.put("message", "Thank you for your order!");


        String emailServiceUrl
                = "http://email-service:8080/send-email";

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP entity with the request body and headers
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(emailMessage, headers);

        // Send the POST request and retrieve the response
        ResponseEntity<String> response = restTemplate.exchange(emailServiceUrl, HttpMethod.POST, requestEntity, String.class);

        // Return the response from the email service
        return response;
    }

}
