package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Cartoon;
import pl.coderslab.entity.Category;

@Component
@Transactional
public class CategoryDao {

	@PersistenceContext
	EntityManager entityManager;

	public Category findById(Long id) {
		return entityManager.find(Category.class, id);
	}
	
	public List<Category> getList(){
		Query query = entityManager.createQuery("SELECT c FROM Category c");
		List<Category> category = query.getResultList();
		return category;
    }
}
