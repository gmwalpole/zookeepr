package main.java.com.catalyst.springboot.services;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Category;

public interface CategoryService {

	/**
	 * Middleman in the getAllCategories chain.
	 * @return List<Category>
	 */
	List<Category> getAllCategories();
}
