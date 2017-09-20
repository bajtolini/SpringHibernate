package pl.coderslab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Person;

@Component
@Transactional
public class PersonDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Person entity) {
		entityManager.persist(entity);
	}
	
	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}
	
	public void update(Person entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Person entity) {
		entityManager.remove(entityManager.contains(entity) ?
				entity : entityManager.merge(entity));
	}
}
