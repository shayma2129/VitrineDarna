package com.darna.repository;
 
import org.springframework.data.repository.CrudRepository;

import com.darna.models.Product;
 
public interface ProductRepository extends CrudRepository<Product, Integer> {
     
    public Product findByName(String name);
}