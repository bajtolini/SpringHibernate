package pl.coderslab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;

@Component
@Transactional
public class BookDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Book entity) {
		entityManager.persist(entity);
	}
	
	public Book findById(Long id) {
		return entityManager.find(Book.class, id);
	}
	
	public void update(Book entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Book entity) {
		entityManager.remove(entityManager.contains(entity) ?
				entity : entityManager.merge(entity));
	}
}
