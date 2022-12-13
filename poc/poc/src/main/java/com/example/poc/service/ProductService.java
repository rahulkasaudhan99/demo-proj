package com.example.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.poc.entity.Product;
import com.example.poc.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public String addProduct(Product product) {
		 repo.save(product);
		 return "Product added Sucessfully";
		 
	}
	@Cacheable(value="products")
	 public Product getProductById(int Id) {
		 log.info("------entered in cache class-----");
         return repo.getById(Id);
    }


}
