package com.test.servicies;

import com.test.dto.OrderDTO;
import com.test.entities.Order_entity;
import com.test.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order_entity add (OrderDTO dto) {
        Order_entity x = new Order_entity(dto.getStatus());
        return this.orderRepo.save(x);
    }

    public List<Order_entity> get() {
        return this.orderRepo.findAll();
    }
    public Optional<Order_entity> getById(int id) {
        return this.orderRepo.findById(id) ;
    }
    public void delete(int id) {
        this.orderRepo.deleteById(id);
    }
}
