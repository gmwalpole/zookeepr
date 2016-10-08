package main.test.com.catalyst.springboot.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.entities.FavoriteFood;
import main.java.com.catalyst.springboot.services.impl.FavoriteFoodServiceImpl;
import main.java.com.catalyst.springboot.webservices.FavoriteFoodWebService;

public class FavoriteFoodServiceImplTest {
	
	private FavoriteFoodServiceImpl mockFavoriteFoodService;
	private FavoriteFoodWebService webService;
	private FavoriteFood dummy;
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockFavoriteFoodService = mock(FavoriteFoodServiceImpl.class);
		webService = new FavoriteFoodWebService();
		webService.setService(mockFavoriteFoodService);
		dummy = new FavoriteFood();
	}
	
	/**
	 * test for getting all foods
	 */
	@Test
	public void getAllFavoriteFoodsTest(){
		webService.getAllFood();
		
		verify(mockFavoriteFoodService).getAllFood();
	}
	
	/**
	 * test for adding foods
	 */
	@Test
	public void addFavoriteFoodTest(){
		webService.addFood(dummy);
		
		verify(mockFavoriteFoodService).add(dummy);
	}
		
	/**
	 * test for updating an food
	 */
	@Test
	public void updateFavoriteFoodTest(){
		webService.updateFood(dummy);
		
		verify(mockFavoriteFoodService).update(dummy);
	}

}
