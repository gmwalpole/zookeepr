package main.java.com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.catalyst.springboot.entities.Enclosure;
import main.java.com.catalyst.springboot.services.CategoryService;
import main.java.com.catalyst.springboot.services.EnclosureService;

@RestController
public class EnclosureWebService {

	@Autowired
	private EnclosureService enclosureService;

	/**
	 * setter for our Enclosure Service
	 */
	public void setService(EnclosureService service) {
		this.enclosureService = service;
	}
	
	/**
	 * This method creates a web interface for the function to add an Enclosure to the database.
	 * @param Enclosure enclosure
	 */
	@RequestMapping(value="/addEnclosure", method=RequestMethod.POST)
	public void addEnclosure(@RequestBody Enclosure enclosure) {
		enclosureService.add(enclosure);	
	}
	
	/**
	 * This method returns a list of all the enclosures in the database.
	 * @return List<Enclosure>
	 */
	@RequestMapping(value="/getEnclosures", method=RequestMethod.GET)
	public List<Enclosure> getAllEnclosures(){
		return enclosureService.getAllEnclosures();
	} 
	
	/**
	 * This method creates a web interface for the function to update an enclosure in the database.
	 * @param Enclosure enclosure
	 */
	@RequestMapping(value="/updateEnclosure", method=RequestMethod.PUT)
	public void updateEnclosure(@RequestBody Enclosure enclosure) {
		enclosureService.update(enclosure);	
	}
	
	/**
	 * This method creates a web interface to delete an enclosure in the database.
	 * @param Integer id
	 */
	@RequestMapping(value="/deleteEnclosure/{id}", method=RequestMethod.DELETE)
	public void deleteEnclosure(@PathVariable Integer id){
		enclosureService.delete(id);
	} 
}
