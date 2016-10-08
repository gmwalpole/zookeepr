package main.java.com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.catalyst.springboot.entities.FavoriteFood;
import main.java.com.catalyst.springboot.services.CategoryService;
import main.java.com.catalyst.springboot.services.FavoriteFoodService;

@RestController
public class FavoriteFoodWebService {

	@Autowired
	private FavoriteFoodService foodService;

	/**
	 * setter for our FavoriteFood Service
	 */
	public void setService(FavoriteFoodService service) {
		this.foodService = service;
	}
	
	/**
	 * This method creates a web interface for the function to add a FavoriteFood to the database.
	 * @param FavoriteFood food
	 */
	@RequestMapping(value="/addFood", method=RequestMethod.POST)
	public void addFood(@RequestBody FavoriteFood food) {
		foodService.add(food);	
	}
	
	/**
	 * This method returns a list of all the foods in the database.
	 * @return List<FavoriteFood>
	 */
	@RequestMapping(value="/getAllFood", method=RequestMethod.GET)
	public List<FavoriteFood> getAllFood(){
		return foodService.getAllFood();
	} 

	/**
	 * This method creates a web interface for the function to update a food in the database.
	 * @param FavoriteFood food
	 */
	@RequestMapping(value="/updateFood", method=RequestMethod.PUT)
	public void updateFood(@RequestBody FavoriteFood food) {
		foodService.update(food);	
	}
	
}
