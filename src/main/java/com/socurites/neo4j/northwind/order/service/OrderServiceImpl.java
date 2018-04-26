package com.socurites.neo4j.northwind.order.service;

import java.util.Collections;
import java.util.Map;

import org.neo4j.ogm.model.Result;
import org.springframework.stereotype.Service;

import com.socurites.neo4j.northwind.model.Order;
import com.socurites.neo4j.northwind.service.GenericService;

@Service
public class OrderServiceImpl extends GenericService<Order> {

	@Override
	protected Class<Order> getEntityType() {
		return Order.class;
	}

	public Iterable<Map<String, Object>> listPopularProducts() {
		String cypher = "MATCH (o:Order)-[:PRODUCT]->(p:Product)\n" + 
				"RETURN p.productName, count(o) as count\n" + 
				"ORDER BY count desc\n" + 
				"LIMIT 10";
	
		Result query = session.query(cypher, Collections.EMPTY_MAP);
		
		return query.queryResults();
	}
	
}


