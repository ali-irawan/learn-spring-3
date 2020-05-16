package com.devtalks.learnspring.session3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devtalks.learnspring.session3.data.ProductRepository;
import com.devtalks.learnspring.session3.entity.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/products")
	public String index(Model model) {
		
		List<Product> productList = repository.findAll();
		
		model.addAttribute("list", productList);
		
		return "products/index";
	}
}
