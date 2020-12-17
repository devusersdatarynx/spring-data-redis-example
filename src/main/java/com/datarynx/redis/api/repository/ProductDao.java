package com.datarynx.redis.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.datarynx.redis.api.entity.Product;

@Repository
public class ProductDao {

	private static final String HASH_KEY = "Product";

	@Autowired
	private RedisTemplate redisTemplate;

	public Product save(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Product> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	public Product findProductById(int id) {
		return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
	}

	public String deleteProduct(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);

		return "Product removed !!!";
	}
}
