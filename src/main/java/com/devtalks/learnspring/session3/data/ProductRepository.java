package com.devtalks.learnspring.session3.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtalks.learnspring.session3.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
