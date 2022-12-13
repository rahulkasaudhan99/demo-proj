package com.example.poc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poc.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product getById(int Id);

	
}
