package com.saran.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prd")
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prdId;
	private String prdName;
	private int prdPrice;

}
