package com.socurites.neo4j.northwind.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NorthWindConfig {
	@Bean
    public Session session() {
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
			    .uri("bolt://localhost")
			    .credentials("neo4j", "1")
			    .build();

			SessionFactory sessionFactory = new SessionFactory(configuration, "com.socurites.neo4j.northwind.model");
			
			return sessionFactory.openSession();
    }
}
