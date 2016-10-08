package main.java.com.catalyst.springboot.daos;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Category;

/**
 * Base Dao interface for the Category object. 
 * @author gwalpole
 */
public interface CategoryDao {

	/**
	 * Gets a list of all categories in the database.
	 * @return List<Category>
	 */
	List<Category> getAllCategories();
}
