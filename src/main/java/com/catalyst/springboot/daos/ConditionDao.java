package main.java.com.catalyst.springboot.daos;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Condition;

/**
 * Base Dao interface for the Condition object. 
 * @author gwalpole
 */
public interface ConditionDao {
	
	/**
	 * Gets a list of all conditions in the database.
	 * @return List<Condition>
	 */
	List<Condition> getAllConditions();
}
