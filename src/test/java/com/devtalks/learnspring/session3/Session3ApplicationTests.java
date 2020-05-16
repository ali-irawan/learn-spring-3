package com.devtalks.learnspring.session3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.devtalks.learnspring.session3.data.ProductRepository;
import com.devtalks.learnspring.session3.entity.Product;

@SpringBootTest
@Transactional
class Session3ApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@BeforeEach
	void beforeTest() {
		productRepository.deleteAll();
		
		productRepository.save(new Product(null, "Kipas Angin", 56000.0));
		productRepository.save(new Product(null, "USB", 12000.0));
		productRepository.save(new Product(null, "Chiki", 8000.0));
		productRepository.save(new Product(null, "Sprite", 6000.0));
		productRepository.save(new Product(null, "Lilin", 56000.0));
		productRepository.save(new Product(null, "Tissue", 26000.0));
	}

	@Test
	void contextLoads() {
		System.out.println("productRepository: " + productRepository);
		
		Product savedProduct = productRepository.save(new Product(null, "Kipas Angin", 56000.0));
		Optional<Product> foundEntity = productRepository.findById(savedProduct.getId());
		
		assertNotNull(foundEntity.get());
		assertEquals(savedProduct.getName(), foundEntity.get().getName());
		assertEquals(savedProduct.getPrice(), foundEntity.get().getPrice());
	}

	@Test
	void testSelect() {
		long count = productRepository.count();
		
		assertEquals(6L, count);
		
		List<Product> productList = productRepository.findAll();
		
		System.out.println("Product List: ");
		for(Product item: productList) {
			System.out.println(item.toString());
		}
	}
}
