package com.devtalks.learnspring.session3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtalks.learnspring.session3.data.ProductRepository;
import com.devtalks.learnspring.session3.entity.Product;
import com.devtalks.learnspring.session3.exception.ProductNotFoundException;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repository;

	@GetMapping("/api/products")
	List<Product> all() {
		return repository.findAll();
	}

	@PostMapping("/api/products")
	Product newProduct(@RequestBody Product newProduct) {
		return repository.save(newProduct);
	}

	// Single item

	@GetMapping("/api/products/{id}")
	Product one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@PutMapping("/api/products/{id}")
	Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

		return repository.findById(id).map(product -> {
			product.setName(newProduct.getName());
			product.setPrice(newProduct.getPrice());
			return repository.save(product);
		}).orElseGet(() -> {
			newProduct.setId(id);
			return repository.save(newProduct);
		});
	}

	@DeleteMapping("/api/products/{id}")
	void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
