package com.devtalks.learnspring.session3.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.devtalks.learnspring.session3.data.ProductRepository;
import com.devtalks.learnspring.session3.entity.Product;

@Controller
public class ProductController {

	private final static Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/products")
	public String index(Model model) {
		
		List<Product> productList = repository.findAll();
		
		model.addAttribute("list", productList);
		
		LOG.debug("Model: ");
		LOG.debug(model.toString());
		
		return "products/index";
	}
}
