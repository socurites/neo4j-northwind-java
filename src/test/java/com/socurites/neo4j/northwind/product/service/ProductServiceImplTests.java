package com.socurites.neo4j.northwind.product.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.socurites.neo4j.northwind.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTests {
	@Autowired
	private ProductServiceImpl productService;
	
	@Test
	public void findAll() {
		Iterable<Product> iterable = productService.findAll();
		
		List<Product> products = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
		
		assertTrue(77 == products.size());
	}
	
	@Test
	public void find() {
		Long id = 18L;
		
		Product product = productService.find(id);
		
		assertTrue(id == product.getId());
		assertTrue("21".equals(product.getProductID()));
		assertTrue("Sir Rodney's Scones".equals(product.getProductName()));
	}
	
	@Test
	public void update() {
		Long id = 18L;
		
		Product product = productService.find(id);
		
		assertTrue(id == product.getId());
		assertTrue("21".equals(product.getProductID()));
		assertTrue("Sir Rodney's Scones".equals(product.getProductName()));
		
		// change productName
		product.setProductName("test title");
		productService.createOrUpdate(product);
		
		// find it and verify
		product = productService.find(id);
		assertTrue("test title".equals(product.getProductName()));
		
		
		// then, revert it
		product.setProductName("Sir Rodney's Scones");
		productService.createOrUpdate(product);
		
		// find it and verify
		product = productService.find(id);
		assertTrue("Sir Rodney's Scones".equals(product.getProductName()));
	}
}
