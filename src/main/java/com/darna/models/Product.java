package com.darna.models;
 
import java.util.function.IntPredicate;

import javax.persistence.*;
 
@Entity
@Table(name = "products") 
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(length = 64, unique = true, nullable = false)
    private String name;
     
    private float price;
     
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
 
    public Product() {
    }
 
    // getters and setters are not shown for brevity...
 
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

	public IntPredicate getName() {
		// TODO Auto-generated method stub
		return null;
	}      
}