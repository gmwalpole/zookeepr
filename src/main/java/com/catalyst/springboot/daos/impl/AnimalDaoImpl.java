package main.java.com.catalyst.springboot.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import main.java.com.catalyst.springboot.daos.AnimalDao;
import main.java.com.catalyst.springboot.entities.Animal;

/**
 * Actual Dao for the Animal object. 
 * @author gwalpole
 */
@Transactional
@Component
public class AnimalDaoImpl implements AnimalDao {

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
	 * Adds a new animal to the database.
	 * @param Animal animal
	 */
	public void add(Animal animal) {
		em.persist(animal);	
	}
	
	/**
	 * Gets a list of all animals in the database.
	 * @return List<Animal>
	 */
	public List<Animal> getAllAnimals(){
		return em.createQuery("SELECT a FROM Animal a", Animal.class)
				.getResultList();
	}
	
	/**
	 * Updates an existing animal in the database.
	 * @param Animal animal
	 */
	public void update(Animal animal){
		em.merge(animal);
	}
	
}
