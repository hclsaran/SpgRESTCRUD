package com.saran.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.model.Product;
@RestController
@RequestMapping("/api")
public class TestController {
	@GetMapping("/test")
	public Product display() {
		Product p=new Product();
		p.setPrdId(111);
		p.setPrdName("Laptop");
		p.setPrdPrice(123);
		return p;
		
	}

}
