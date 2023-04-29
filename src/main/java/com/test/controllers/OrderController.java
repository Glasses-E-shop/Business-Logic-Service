package com.test.controllers;


import com.test.dto.OrderDTO;
import com.test.entities.Order_entity;
import com.test.servicies.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
