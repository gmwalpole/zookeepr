package main.test.com.catalyst.springboot.daos.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import main.java.com.catalyst.springboot.daos.impl.EnclosureDaoImpl;
import main.java.com.catalyst.springboot.entities.Enclosure;

public class EnclosureDaoImplTest {
	
	// the target to be tested upon
	private EnclosureDaoImpl target;

	// a mocked EM so that nothing actually happens
	private EntityManager mockEm;

	/**
	 * set up the playing field.
	 */

	@Before
	public void setup() {
		target = new EnclosureDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	/**
	 * a test for reading the whole enclosure list
	 */

	@Test
	public void getAllEnclosuresTest() {
		List<Enclosure> expected = new ArrayList<Enclosure>();

		
		TypedQuery<Enclosure> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Enclosure.class))).thenReturn(
				mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllEnclosures();

		verify(mockTypedQuery, times(1)).getResultList();
	}

	/**
	 * test for adding
	 */
	@Test
	public void addTest(){
		Enclosure dummy = new Enclosure();
		target.add(dummy);
		
		verify(mockEm, times(1)).persist(dummy);
	}
	
	/**
	 * test for updating
	 */
	@Test
	public void updateTest(){
		Enclosure dummy = new Enclosure();
		target.update(dummy);
		
		verify(mockEm, times(1)).merge(dummy);
	}

	/**
	 * test for deleting
	 */
	/*@Test
	public void deleteTest(){
		Enclosure dummy = new Enclosure();
		target.delete(null);
		
		verify(mockEm, times(1)).merge(dummy);
	}*/
	
}
