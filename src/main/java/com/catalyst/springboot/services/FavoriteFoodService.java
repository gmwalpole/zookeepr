package main.java.com.catalyst.springboot.services;

import java.util.List;

import main.java.com.catalyst.springboot.entities.FavoriteFood;

public interface FavoriteFoodService {

	/**
	 * Calls the Dao's add for a FavoriteFood object
	 * @param FavoriteFood food
	 */
	void add(FavoriteFood food);
	
	/**
	 * Middleman in the getAllFood chain.
	 * @return List<FavoriteFood>
	 */
	List<FavoriteFood> getAllFood();
	
	/**
	 * Calls the Dao's update for a FavoriteFood object
	 * @param FavoriteFood food
	 */
	void update(FavoriteFood food);
	
}
