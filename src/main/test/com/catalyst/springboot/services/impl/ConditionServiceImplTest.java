package main.test.com.catalyst.springboot.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.entities.Condition;
import main.java.com.catalyst.springboot.services.impl.ConditionServiceImpl;
import main.java.com.catalyst.springboot.webservices.ConditionWebService;

public class ConditionServiceImplTest {

	private ConditionServiceImpl mockConditionService;
	private ConditionWebService webService;
	private Condition dummy;
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockConditionService = mock(ConditionServiceImpl.class);
		webService = new ConditionWebService();
		webService.setService(mockConditionService);
		dummy = new Condition();
	}

	/**
	 * test for getting all conditions
	 */
	@Test
	public void getAllCategoriesTest(){
		webService.getConditions();
		
		verify(mockConditionService).getAllConditions();
	}

}
