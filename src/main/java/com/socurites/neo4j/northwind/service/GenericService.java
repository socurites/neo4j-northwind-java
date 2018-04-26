package com.socurites.neo4j.northwind.service;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.socurites.neo4j.northwind.model.Entity;

public abstract class GenericService<T extends Entity> implements Service<T> {
	@Autowired
	protected Session session;
	
	private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
	
	@Override
	public Iterable<T> findAll() {
		return session.loadAll(getEntityType(), DEPTH_LIST);
	}

	public T find(Long id) {
		return session.load(getEntityType(), id, DEPTH_ENTITY);
	}

	@Override
	public void delete(Long id) {
	session.delete(session.load(getEntityType(), id));	
	}

	@Override
	public T createOrUpdate(T entity) {
		session.save(entity, DEPTH_ENTITY);
		
		return find(entity.getId());
	}
	
	protected abstract Class<T> getEntityType();
}
