package main.java.com.catalyst.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Condition entity object.
 * @author gwalpole
 */
@Entity
@Table(name = "condition")
public class Condition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "condition_id")
	private Integer conditionId;
	
	@NotNull
	@Size(min=0,max=255)
	@Column(name = "condition")
	private String condition;

	/**
	 * Auto-Generated getter for conditionId
	 * @return conditionId
	 */
	public Integer getConditionId() {
		return conditionId;
	}

	/**
	 * Auto-Generated setter for conditionId
	 * @param conditionId
	 */
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	/**
	 * Auto-Generated getter for condition
	 * @return condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Auto-Generated setter for condition
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}	
	
	
}
