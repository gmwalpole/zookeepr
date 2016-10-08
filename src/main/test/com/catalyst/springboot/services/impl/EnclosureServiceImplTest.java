package main.test.com.catalyst.springboot.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.entities.Enclosure;
import main.java.com.catalyst.springboot.services.impl.EnclosureServiceImpl;
import main.java.com.catalyst.springboot.webservices.EnclosureWebService;

public class EnclosureServiceImplTest {
	
	private EnclosureServiceImpl mockEnclosureService;
	private EnclosureWebService webService;
	private Enclosure dummy;
	
	/**
	 * set up the stage
	 */
	@Before
	public void setup(){
		mockEnclosureService = mock(EnclosureServiceImpl.class);
		webService = new EnclosureWebService();
		webService.setService(mockEnclosureService);
		dummy = new Enclosure();
	}

	/**
	 * test for getting all enclosures
	 */
	@Test
	public void getAllEnclosuresTest(){
		webService.getAllEnclosures();
		
		verify(mockEnclosureService).getAllEnclosures();
	}
	
	/**
	 * test for adding enclosures
	 */
	@Test
	public void addEnclosureTest(){
		webService.addEnclosure(dummy);
		
		verify(mockEnclosureService).add(dummy);
	}
		
	/**
	 * test for updating an enclosure
	 */
	@Test
	public void updateEnclosureTest(){
		webService.updateEnclosure(dummy);
		
		verify(mockEnclosureService).update(dummy);
	}
	
	/**
	 * test for deleting an enclosure
	 */
	@Test
	public void deleteEnclosureTest(){
		webService.deleteEnclosure(1);
		
		verify(mockEnclosureService).delete(1);
	}

}
