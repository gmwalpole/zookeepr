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
 * The Enclosure entity object.
 * 
 * @author gwalpole
 */
@Entity
@Table(name = "enclosure")
public class Enclosure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enclosure_id")
	private Integer enclosureId;

	@NotNull
	@Size(min=1,max=255)
	@Column(name = "name")
	private String name;
	
	@Column(name = "animal_id")
	private Integer animalId;

	@Column(name = "animal_quantity")
	private Integer animalQuantity;
	
	@NotNull
	@Size(min=1,max=255)
	@Column(name = "feeding_time")
	private String feedingTime;

	@Column(name = "condition_id")
	private Integer conditionId;
	
	/**
	 * Generic getter for enclosureId
	 * @return Integer enclosureId
	 */
	public Integer getEnclosureId() {
		return enclosureId;
	}

	/**
	 * Generic setter for enclosureId
	 * @param Integer enclosureId
	 */
	public void setEnclosureId(Integer enclosureId) {
		this.enclosureId = enclosureId;
	}

	/**
	 * Generic getter for name
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Generic setter for name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Generic getter for animalId
	 * @return Integer animalId
	 */
	public Integer getAnimalId() {
		return animalId;
	}

	/**
	 * Generic setter for animalId
	 * @param Integer animalId
	 */
	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	/**
	 * Generic getter for animalQuantity
	 * @return Integer animalQuantity
	 */
	public Integer getAnimalQuantity() {
		return animalQuantity;
	}

	/**
	 * Generic setter for animalQuantity
	 * @param Integer animalQuantity
	 */
	public void setAnimalQuantity(Integer animalQuantity) {
		this.animalQuantity = animalQuantity;
	}

	/**
	 * Generic getter for feedingTime
	 * @return String feedingTime
	 */
	public String getFeedingTime() {
		return feedingTime;
	}

	/**
	 * Generic setter for feedingTime
	 * @param String feedingTime
	 */
	public void setFeedingTime(String feedingTime) {
		this.feedingTime = feedingTime;
	}

	/**
	 * Generic getter for conditionId
	 * @return Integer conditionId
	 */
	public Integer getConditionId() {
		return conditionId;
	}

	/**
	 * Generic setter for name
	 * @param Integer conditionId
	 */
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}


}
