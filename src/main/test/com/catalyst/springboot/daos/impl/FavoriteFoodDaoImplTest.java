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

import main.java.com.catalyst.springboot.daos.impl.FavoriteFoodDaoImpl;
import main.java.com.catalyst.springboot.entities.Animal;
import main.java.com.catalyst.springboot.entities.FavoriteFood;

public class FavoriteFoodDaoImplTest {
	
	// the target to be tested upon
	private FavoriteFoodDaoImpl target;

	// a mocked EM so that nothing actually happens
	private EntityManager mockEm;

	/**
	 * set up the playing field.
	 */

	@Before
	public void setup() {
		target = new FavoriteFoodDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	/**
	 * a test for reading the whole enclosure list
	 */

	@Test
	public void getAllEnclosuresTest() {
		List<FavoriteFood> expected = new ArrayList<FavoriteFood>();

		
		TypedQuery<FavoriteFood> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(FavoriteFood.class))).thenReturn(
				mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllFood();

		verify(mockTypedQuery, times(1)).getResultList();
	}

	/**
	 * test for adding
	 */
	@Test
	public void addTest(){
		FavoriteFood dummy = new FavoriteFood();
		target.add(dummy);
		
		verify(mockEm, times(1)).persist(dummy);
	}
	
	/**
	 * test for updating
	 */
	@Test
	public void updateTest(){
		FavoriteFood dummy = new FavoriteFood();
		target.update(dummy);
		
		verify(mockEm, times(1)).merge(dummy);
	}

}
