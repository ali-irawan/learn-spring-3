package com.devtalks.learnspring.session3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devtalks.learnspring.session3.data.ProductRepository;
import com.devtalks.learnspring.session3.entity.Product;

@SpringBootTest
class Session3ApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void contextLoads() {
		System.out.println("productRepository: " + productRepository);
		
		Product savedProduct = productRepository.save(new Product(null, "Kipas Angin", 56000.0));
		Optional<Product> foundEntity = productRepository.findById(savedProduct.getId());
		  
		assertNotNull(foundEntity.get());
		assertEquals(savedProduct.getName(), foundEntity.get().getName());
		assertEquals(savedProduct.getPrice(), foundEntity.get().getPrice());
	}

}
