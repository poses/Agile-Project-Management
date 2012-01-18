package com.agile.data.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import com.agile.data.dao.interfaces.PersonDao;
import com.agile.data.dataobjects.Person;

public class PersonDaoJPAImpl extends AbstractDaoJPAImpl<Person> implements	PersonDao {

	public PersonDaoJPAImpl() {
		super(Person.class);
	}

	@Transactional
	public List<Person> findAll() {
		return getJpaTemplate().execute(new JpaCallback<List<Person>>() {
			public List<Person> doInJpa(EntityManager em) throws PersistenceException {
				TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
				return query.getResultList();
			}
		});
	}

	@Transactional
	public int countAll() {
		return getJpaTemplate().execute(new JpaCallback<Integer>() {
			public Integer doInJpa(EntityManager em) throws PersistenceException {
				TypedQuery<Integer> query = em.createQuery("select count(p) from Person p", Integer.class);
				return query.getSingleResult().intValue();
			}
		});
	}

}
