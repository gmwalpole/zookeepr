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

import main.java.com.catalyst.springboot.daos.impl.CategoryDaoImpl;
import main.java.com.catalyst.springboot.entities.Category;


public class CategoryDaoImplTest {

	// the target to be tested upon
		private CategoryDaoImpl target;

		// a mocked EM so that nothing actually happens
		private EntityManager mockEm;

		/**
		 * set up the playing field.
		 */

		@Before
		public void setup() {
			target = new CategoryDaoImpl();
			mockEm = mock(EntityManager.class);
			target.setEm(mockEm);
		}

		/**
		 * a test for READing the whole category list
		 */

		@Test
		public void getAllCategorysTest() {
			List<Category> expected = new ArrayList<Category>();

			
			TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(
					mockTypedQuery);
			when(mockTypedQuery.getResultList()).thenReturn(expected);

			target.getAllCategories();

			verify(mockTypedQuery, times(1)).getResultList();
		}

}
