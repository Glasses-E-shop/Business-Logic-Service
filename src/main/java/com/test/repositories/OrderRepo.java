package com.test.repositories;

import com.test.entities.Order_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order_entity, Integer> {
}
