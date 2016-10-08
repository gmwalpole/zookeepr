package main.java.com.catalyst.springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.catalyst.springboot.daos.ConditionDao;
import main.java.com.catalyst.springboot.entities.Condition;
import main.java.com.catalyst.springboot.services.ConditionService;

@Service
public class ConditionServiceImpl implements ConditionService {
	
	@Autowired
	private ConditionDao conditionDao;

	/**
	 * Middleman in the getAllConditions chain.
	 * @return List<Condition>
	 */
	public List<Condition> getAllConditions(){
		return conditionDao.getAllConditions();
	}
}
