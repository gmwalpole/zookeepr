package main.java.com.catalyst.springboot.daos;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Animal;

/**
 * Base Dao interface for the Animal object. 
 * @author gwalpole
 */
public interface AnimalDao {

	/**
	 * Adds a new animal to the database.
	 * @param Animal animal
	 */
	void add(Animal animal);

	/**
	 * Gets a list of all animals in the database.
	 * @return List<Animal>
	 */
	List<Animal> getAllAnimals();

	/**
	 * Updates an existing animal in the database.
	 * @param Animal animal
	 */
	void update(Animal animal);
	
}
