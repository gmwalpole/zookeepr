package main.java.com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.catalyst.springboot.daos.EnclosureDao;
import main.java.com.catalyst.springboot.entities.Enclosure;
import main.java.com.catalyst.springboot.services.EnclosureService;

@Service
public class EnclosureServiceImpl implements EnclosureService {

	@Autowired
	private EnclosureDao enclosureDao;
	
	/**
	 * Calls the Dao's add for an Enclosure object
	 * @param Enclosure enclosure
	 */
	public void add(Enclosure enclosure) {
		enclosureDao.add(enclosure);	
	}
	
	/**
	 * Middleman in the getAllEnclosures chain.
	 * @return List<Enclosure>
	 */
	public List<Enclosure> getAllEnclosures(){
		return enclosureDao.getAllEnclosures();
	}
	
	/**
	 * Calls the Dao's update for an Enclosure object
	 * @param Enclosure enclosure
	 */
	public void update(Enclosure enclosure){
		enclosureDao.update(enclosure);		
	}
	
	/**
	 * Calls the Dao's delete, passing an Enclosure's id
	 * @param Integer id
	 */
	public void delete(Integer id){
		enclosureDao.delete(id);			
	}
	
}
