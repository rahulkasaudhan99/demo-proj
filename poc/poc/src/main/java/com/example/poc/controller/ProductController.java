package com.example.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.entity.Product;
import com.example.poc.service.ProductService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class ProductController {

	@Autowired
	ProductService redisService;
	
	
	@GetMapping("/product/{id}")
    public String getProduct(@PathVariable int id) {
		log.info("------entered in cache class controller-----");
        return redisService.getProductById(id).toString();
    }
	
	@PostMapping("/product/add")
    public String addProduct(@RequestBody Product product) {
        return redisService.addProduct(product);
    }
}
