package main.java.com.catalyst.springboot.services;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Enclosure;

public interface EnclosureService {

	/**
	 * Calls the Dao's add for an Enclosure object
	 * @param Enclosure enclosure
	 */
	void add(Enclosure enclosure);
	
	/**
	 * Middleman in the getAllEnclosures chain.
	 * @return List<Enclosure>
	 */
	List<Enclosure> getAllEnclosures();
	
	/**
	 * Calls the Dao's update for an Enclosure object
	 * @param Enclosure enclosure
	 */
	void update(Enclosure enclosure);
	
	/**
	 * Calls the Dao's delete, passing an Enclosure's id
	 * @param Integer id
	 */
	void delete(Integer id);
}
