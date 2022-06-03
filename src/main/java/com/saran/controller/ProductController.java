package com.saran.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.service.internal.ServiceDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saran.model.Product;
import com.saran.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@GetMapping("/products")
	public List<Product>  list(){
		return service.getAllPrds();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product>  getMyProductById(@PathVariable Integer id){
		try {
		Product prd=service.getProductById(id);
		
		return new ResponseEntity<Product>(prd,HttpStatus.OK);//200
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);//404
		}
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prd) {
		service.saveProduct(prd);
		
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product prd) {
		service.saveOrUpdate(prd);
		return prd;
		 
	}
	
	
	
	
	

}
