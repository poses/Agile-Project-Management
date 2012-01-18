package com.agile.data.dao.jpa;

import java.io.Serializable;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.agile.data.dao.interfaces.Dao;
import com.agile.data.dataobjects.DomainObject;

public abstract class AbstractDaoJPAImpl<T extends DomainObject> extends JpaDaoSupport implements Dao<T> {
	private Class<T> domainClass;
	
	public AbstractDaoJPAImpl(Class<T> domainClass){
		this.domainClass = domainClass;
	}
	
	@Transactional
	public void delete(T object){
		getJpaTemplate().remove(object);
	}
	
	@Transactional
	public T load(Serializable id){
		return (T) getJpaTemplate().find(domainClass, id);
	}
	
	@Transactional
	public T save(T object){
		return getJpaTemplate().merge(object);
	}
}
