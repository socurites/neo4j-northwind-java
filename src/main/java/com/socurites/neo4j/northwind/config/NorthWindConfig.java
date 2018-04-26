package com.socurites.neo4j.northwind.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class NorthWindConfig {
	@Bean
    public Session session() {
		Configuration configuration = new Configuration.Builder()
			    .uri("bolt://localhost")
			    .credentials("neo4j", "1")
			    .build();

			SessionFactory sessionFactory = new SessionFactory(configuration, "com.socurites.neo4j.northwind.model");
			
			return sessionFactory.openSession();
    }
}
