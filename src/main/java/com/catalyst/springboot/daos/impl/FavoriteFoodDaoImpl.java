package main.java.com.catalyst.springboot.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import main.java.com.catalyst.springboot.daos.FavoriteFoodDao;
import main.java.com.catalyst.springboot.entities.FavoriteFood;

/**
 * Actual Dao for the FavoriteFood object. 
 * @author gwalpole
 */
@Transactional
@Component
public class FavoriteFoodDaoImpl implements FavoriteFoodDao {

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
	 * Adds a new food to the database.
	 * @param FavoriteFood food
	 */
	public void add(FavoriteFood food){
		em.persist(food);
	}
	
	/**
	 * Gets a list of all foods in the database.
	 * @return List<Enclosure>
	 */
	public List<FavoriteFood> getAllFood(){
		return em.createQuery("SELECT f FROM FavoriteFood f", FavoriteFood.class)
				.getResultList();
	}

	/**
	 * Updates an existing food in the database.
	 * @param FavoriteFood food
	 */
	public void update(FavoriteFood food){
		em.merge(food);
	}
	
}
