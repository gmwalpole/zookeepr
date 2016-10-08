package main.java.com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.catalyst.springboot.daos.AnimalDao;
import main.java.com.catalyst.springboot.entities.Animal;
import main.java.com.catalyst.springboot.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalDao animalDao;
	
	/**
	 * Calls the Dao's add for an Animal object
	 * @param Animal animal
	 */
	public void add(Animal animal) {
	  animalDao.add(animal);
	}
	
	/**
	 * Middleman in the getAllAnimals chain.
	 * @return List<Animal>
	 */
	public List<Animal> getAllAnimals() {
	  return animalDao.getAllAnimals();
	}
	
	/**
	 * Calls the Dao's update for an Animal object
	 * @param Animal animal
	 */
	public void updateAnimal(Animal animal){
		animalDao.update(animal);
	} 
	
}
