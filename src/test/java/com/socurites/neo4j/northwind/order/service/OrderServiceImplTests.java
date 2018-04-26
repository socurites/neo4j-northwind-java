package com.socurites.neo4j.northwind.order.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTests {
	@Autowired
	private OrderServiceImpl orderService;
	
	@Test
	public void getPopularProduct() {
		Iterable<Map<String, Object>> iterable = orderService.listPopularProducts();
		
		for ( Map<String, Object> itemMap : iterable ) {
			System.out.println(String.format("%s\t\t\t%d", itemMap.get("p.productName"), itemMap.get("count")));
		}
		
	}
}
