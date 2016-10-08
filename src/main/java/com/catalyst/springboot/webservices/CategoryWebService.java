package main.java.com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.catalyst.springboot.entities.Category;
import main.java.com.catalyst.springboot.services.AnimalService;
import main.java.com.catalyst.springboot.services.CategoryService;

@RestController
public class CategoryWebService {

	@Autowired
	private CategoryService categoryService;

	/**
	 * setter for our Category Service
	 */
	public void setService(CategoryService service) {
		this.categoryService = service;
	}
	
	/**
	 * This method returns a list of all the categories in the database.
	 * @return List<Category>
	 */
	@RequestMapping(value="/getCategories", method=RequestMethod.GET)
	public List<Category> getCategories(){
		return categoryService.getAllCategories();
	} 
}
