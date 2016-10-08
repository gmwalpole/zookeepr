package main.java.com.catalyst.springboot.services;

import java.util.List;

import main.java.com.catalyst.springboot.entities.Condition;

public interface ConditionService {

	/**
	 * Middleman in the getAllConditions chain.
	 * @return List<Condition>
	 */
	List<Condition> getAllConditions();
}
