package com.test.controllers;


import com.test.dto.ProductDTO;
import com.test.entities.Product;
import com.test.servicies.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private Productservice productservice;

    @PostMapping
    @ResponseBody
    public ProductDTO add(@RequestBody ProductDTO p) {
        Product nou = this.productservice.add(p);
        return p;
    }
    @GetMapping
    @ResponseBody
    public List<Product> get() {
        return this.productservice.getProducts();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Product> getById(@PathVariable(name="id") int id) {
        return this.productservice.getProduct(id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") int id) {
        this.productservice.delProduct(id);
        return "Deleted product with id: " + id;
    }
}
