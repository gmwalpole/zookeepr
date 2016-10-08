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

import main.java.com.catalyst.springboot.daos.impl.ConditionDaoImpl;
import main.java.com.catalyst.springboot.entities.Condition;

public class ConditionDaoImplTest {

	// the target to be tested upon
		private ConditionDaoImpl target;

		// a mocked EM so that nothing actually happens
		private EntityManager mockEm;

		/**
		 * set up the playing field.
		 */

		@Before
		public void setup() {
			target = new ConditionDaoImpl();
			mockEm = mock(EntityManager.class);
			target.setEm(mockEm);
		}

		/**
		 * a test for READing the whole condition list
		 */

		@Test
		public void getAllConditionsTest() {
			List<Condition> expected = new ArrayList<Condition>();

			
			TypedQuery<Condition> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Condition.class))).thenReturn(
					mockTypedQuery);
			when(mockTypedQuery.getResultList()).thenReturn(expected);

			target.getAllConditions();

			verify(mockTypedQuery, times(1)).getResultList();
		}

}
