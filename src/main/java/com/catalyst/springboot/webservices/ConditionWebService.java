package main.java.com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.catalyst.springboot.entities.Condition;
import main.java.com.catalyst.springboot.services.CategoryService;
import main.java.com.catalyst.springboot.services.ConditionService;

@RestController
public class ConditionWebService {
	
	@Autowired
	private ConditionService conditionService;

	/**
	 * setter for our Condition Service
	 */
	public void setService(ConditionService service) {
		this.conditionService = service;
	}
	
	/**
	 * This method returns a list of all the conditions in the database.
	 * @return List<Condition>
	 */
	@RequestMapping(value="/getConditions", method=RequestMethod.GET)
	public List<Condition> getConditions(){
		return conditionService.getAllConditions();
	} 
}
