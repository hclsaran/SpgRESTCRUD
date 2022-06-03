package com.saran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saran.model.Product;
import com.saran.repo.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private  ProductRepository repo;
	
	public List<Product> getAllPrds(){
		return repo.findAll();
	}
	
	public void saveProduct(Product prd) {
		repo.save(prd);
		
	}

	public Product getProductById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
	
	public void saveOrUpdate(Product prd) {
		repo.save(prd);
	}
	public void updateProduct(Product prd,int prdId) {
		repo.save(prd);
	}
	
	
	
	
}
