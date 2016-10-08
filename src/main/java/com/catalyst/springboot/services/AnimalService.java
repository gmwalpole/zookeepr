package main.java.com.catalyst.springboot.services;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Animal;

public interface AnimalService {

	/**
	 * Calls the Dao's add for an Animal object
	 * @param Animal animal
	 */
	void add(Animal animal);
	
	/**
	 * Middleman in the getAllAnimals chain.
	 * @return List<Animal>
	 */
	List<Animal> getAllAnimals();

	/**
	 * Calls the Dao's update for an Animal object
	 * @param Animal animal
	 */
	void updateAnimal(Animal animal);
	
}
