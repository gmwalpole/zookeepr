package main.java.com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.catalyst.springboot.entities.Animal;
import main.java.com.catalyst.springboot.services.AnimalService;

@RestController
public class AnimalWebService {

	@Autowired
	private AnimalService animalService;
	
	/**
	 * setter for our Animal Service
	 */
	public void setService(AnimalService service) {
		this.animalService = service;
	}
	
	/**
	 * This method creates a web interface for the function to add an Animal to the database.
	 * @param Animal animal
	 */
	@RequestMapping(value="/addAnimal", method=RequestMethod.POST)
	public void addAnimal(@RequestBody Animal animal){
		animalService.add(animal);
	} 
	
	/**
	 * This method returns a list of all the animals in the database.
	 * @return List<Animal>
	 */
	@RequestMapping(value="/getAnimals", method=RequestMethod.GET)
	public List<Animal> getAllAnimals(){
		return animalService.getAllAnimals();
	} 
	
	/**
	 * This method creates a web interface for the function to update an animal in the database.
	 * @param Animal animal
	 */
	@RequestMapping(value="/updateAnimal", method=RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal animal){
		animalService.updateAnimal(animal);
	} 

}
