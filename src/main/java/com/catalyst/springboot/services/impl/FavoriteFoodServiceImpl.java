package main.java.com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.catalyst.springboot.daos.FavoriteFoodDao;
import main.java.com.catalyst.springboot.entities.FavoriteFood;
import main.java.com.catalyst.springboot.services.FavoriteFoodService;

@Service
public class FavoriteFoodServiceImpl implements FavoriteFoodService{

	@Autowired
	private FavoriteFoodDao foodDao;
	
	/**
	 * Calls the Dao's add for a FavoriteFood object
	 * @param FavoriteFood food
	 */
	public void add(FavoriteFood food){
		foodDao.add(food);
	}
	
	/**
	 * Middleman in the getAllFood chain.
	 * @return List<FavoriteFood>
	 */
	public List<FavoriteFood> getAllFood(){
		return foodDao.getAllFood();
	}
	
	/**
	 * Calls the Dao's update for a FavoriteFood object
	 * @param FavoriteFood food
	 */
	public void update(FavoriteFood food){
		foodDao.update(food);
	}
	
}
