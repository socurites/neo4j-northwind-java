package com.socurites.neo4j.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Neo4jNorthwindJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jNorthwindJavaApplication.class, args);
	}
}
