package com.socurites.neo4j.northwind.product.service;

import org.springframework.stereotype.Service;

import com.socurites.neo4j.northwind.model.Product;
import com.socurites.neo4j.northwind.service.GenericService;

@Service
public class ProductServiceImpl extends GenericService<Product> {

	@Override
	protected Class<Product> getEntityType() {
		return Product.class;
	}

}
