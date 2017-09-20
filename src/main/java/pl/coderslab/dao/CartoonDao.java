package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Cartoon;

@Component
@Transactional
public class CartoonDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Cartoon entity) {
		entityManager.persist(entity);
	}
	
	public Cartoon findById(Long id) {
		return entityManager.find(Cartoon.class, id);
	}
	
	public void update(Cartoon entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Cartoon entity) {
		entityManager.remove(entityManager.contains(entity) ?
				entity : entityManager.merge(entity));
	}

	public List<Cartoon> getAll() {
		Query query = entityManager.createQuery("SELECT c FROM Cartoon c");
		return query.getResultList();
	}
}
