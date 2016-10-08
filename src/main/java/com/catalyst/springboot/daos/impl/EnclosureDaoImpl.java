package main.java.com.catalyst.springboot.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

import main.java.com.catalyst.springboot.daos.EnclosureDao;
import main.java.com.catalyst.springboot.entities.Enclosure;

/**
 * Actual Dao for the Enclosure object. 
 * @author gwalpole
 */
@Transactional
@Component
public class EnclosureDaoImpl implements EnclosureDao {

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
	 * Adds a new enclosure to the database.
	 * @param Enclosure enclosure
	 */
	public void add(Enclosure enclosure) {
		em.persist(enclosure);	
	}
	
	/**
	 * Gets a list of all enclosures in the database.
	 * @return List<Enclosure>
	 */
	public List<Enclosure> getAllEnclosures(){
		return em.createQuery("SELECT e FROM Enclosure e", Enclosure.class)
				.getResultList();
	}
	
	/**
	 * Updates an existing enclosure in the database.
	 * @param Enclosure enclosure
	 */
	public void update(Enclosure enclosure){
		em.merge(enclosure);		
	}
	
	/**
	 * Deletes an existing enclosure in the database with the matching Id.
	 * @param Integer id
	 */
	public void delete(Integer id){
		Enclosure enclosure = em.find(Enclosure.class, id);
		em.remove(enclosure);		
	}
	
}
