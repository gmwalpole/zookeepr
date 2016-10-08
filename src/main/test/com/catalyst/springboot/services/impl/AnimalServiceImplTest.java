package main.test.com.catalyst.springboot.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.entities.Animal;
import main.java.com.catalyst.springboot.services.impl.AnimalServiceImpl;
import main.java.com.catalyst.springboot.webservices.AnimalWebService;


public class AnimalServiceImplTest {
	
	private AnimalServiceImpl mockAnimalService;
	private AnimalWebService webService;
	private Animal dummy;
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockAnimalService = mock(AnimalServiceImpl.class);
		webService = new AnimalWebService();
		webService.setService(mockAnimalService);
		dummy = new Animal();
	}
	
	/**
	 * test for getting all animals
	 */
	@Test
	public void getAllAnimalsTest(){
		webService.getAllAnimals();
		
		verify(mockAnimalService).getAllAnimals();
	}
	
	/**
	 * test for adding animals
	 */
	@Test
	public void addAnimalTest(){
		webService.addAnimal(dummy);
		
		verify(mockAnimalService).add(dummy);
	}
		
	/**
	 * test for updating an animal
	 */
	@Test
	public void updateAnimalTest(){
		webService.updateAnimal(dummy);
		
		verify(mockAnimalService).updateAnimal(dummy);
	}

}
