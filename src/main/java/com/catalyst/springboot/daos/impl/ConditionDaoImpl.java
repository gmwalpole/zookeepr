package main.java.com.catalyst.springboot.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import main.java.com.catalyst.springboot.daos.ConditionDao;
import main.java.com.catalyst.springboot.entities.Condition;

/**
 * Actual Dao for the Condition object. 
 * @author gwalpole
 */
@Transactional
@Component
public class ConditionDaoImpl implements ConditionDao {

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
	 * Gets a list of all conditions in the database.
	 * @return List<Condition>
	 */
	public List<Condition> getAllConditions(){
		return em.createQuery("SELECT c FROM Condition c", Condition.class)
				.getResultList();
	}
}
