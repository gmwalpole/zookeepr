package main.java.com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.catalyst.springboot.daos.CategoryDao;
import main.java.com.catalyst.springboot.entities.Category;
import main.java.com.catalyst.springboot.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * Middleman in the getAllCategories chain.
	 * @return List<Category>
	 */
	public List<Category> getAllCategories(){
		return categoryDao.getAllCategories();
	}
}
