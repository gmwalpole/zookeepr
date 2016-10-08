package main.java.com.catalyst.springboot.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import main.java.com.catalyst.springboot.daos.CategoryDao;
import main.java.com.catalyst.springboot.entities.Category;

/**
 * Actual Dao for the Category object. 
 * @author gwalpole
 */
@Transactional
@Component
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Sets the EntityManager
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Gets a list of all categories in the database.
	 * @return List<Category>
	 */
	public List<Category> getAllCategories(){
		return em.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
	}

}
