package main.java.com.catalyst.springboot.daos;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Enclosure;

/**
 * Base Dao interface for the Enclosure object. 
 * @author gwalpole
 */
public interface EnclosureDao {

	/**
	 * Adds a new enclosure to the database.
	 * @param Enclosure enclosure
	 */
	void add(Enclosure enclosure);

	/**
	 * Gets a list of all enclosures in the database.
	 * @return List<Enclosure>
	 */
	List<Enclosure> getAllEnclosures();

	/**
	 * Updates an existing enclosure in the database.
	 * @param Enclosure enclosure
	 */
	void update(Enclosure enclosure);

	/**
	 * Deletes an existing enclosure in the database with the matching Id.
	 * @param Integer id
	 */
	void delete(Integer id);
}
