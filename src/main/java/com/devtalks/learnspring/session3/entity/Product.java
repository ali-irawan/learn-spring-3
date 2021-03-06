package com.devtalks.learnspring.session3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {

	@Id
	@SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq", allocationSize = 1, initialValue = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private double price;

	public Product() {
		super();
		this.name = "";
		this.price = 0.0;
	}

	public Product(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder  builder = new StringBuilder();
		builder.append(id);
		builder.append('\t');
		builder.append(name);
		builder.append('\t');
		builder.append(price);
		return builder.toString();
	}

	
}
