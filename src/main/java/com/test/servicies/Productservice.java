package com.test.servicies;


import com.test.dto.ProductDTO;
import com.test.entities.Product;
import com.test.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Productservice {
    @Autowired
    private ProductRepo productRepo;
    public Product add (ProductDTO productDTO) {
        Product x = new Product(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDiopter(),
                productDTO.getStock());
        return this.productRepo.save(x);
    }

    public List<Product> getProducts() {
        return this.productRepo.findAll();
    }
    public Optional<Product> getProduct(int id) {
        return this.productRepo.findById(id) ;
    }
    public void delProduct(int id) {
        this.productRepo.deleteById(id);
    }
}
