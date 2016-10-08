package main.test.com.catalyst.springboot.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.entities.Category;
import main.java.com.catalyst.springboot.services.impl.CategoryServiceImpl;
import main.java.com.catalyst.springboot.webservices.CategoryWebService;

public class CategoryServiceImplTest {

	private CategoryServiceImpl mockCategoryService;
	private CategoryWebService webService;
	private Category dummy;
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockCategoryService = mock(CategoryServiceImpl.class);
		webService = new CategoryWebService();
		webService.setService(mockCategoryService);
		dummy = new Category();
	}
	

	/**
	 * test for getting all categories
	 */
	@Test
	public void getAllCategoriesTest(){
		webService.getCategories();
		
		verify(mockCategoryService).getAllCategories();
	}
	
}
