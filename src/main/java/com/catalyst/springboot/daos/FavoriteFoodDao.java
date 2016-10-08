package main.java.com.catalyst.springboot.daos;

import java.util.List;

import main.java.com.catalyst.springboot.entities.FavoriteFood;

/**
 * Base Dao interface for the FavoriteFood object. 
 * @author gwalpole
 */
public interface FavoriteFoodDao {

	/**
	 * Adds a new food to the database.
	 * @param FavoriteFood food
	 */
	void add(FavoriteFood food);

	/**
	 * Gets a list of all foods in the database.
	 * @return List<Enclosure>
	 */
	List<FavoriteFood> getAllFood();

	/**
	 * Updates an existing food in the database.
	 * @param FavoriteFood food
	 */
	void update(FavoriteFood food);
	
}
