package com.saran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saran.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
