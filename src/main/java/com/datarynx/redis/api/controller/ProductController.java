package com.datarynx.redis.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datarynx.redis.api.entity.Product;
import com.datarynx.redis.api.repository.ProductDao;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDao  dao;
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product)
	{
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProduct()
	{
		return dao.findAll();
		
	}
	
	@GetMapping("/{id}")
	@Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
	public Product getProductById(@PathVariable int id)
	{
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(key = "#id", value = "Product")
	public String remove(@PathVariable int id)
	{
		return dao.deleteProduct(id);
	}
}
