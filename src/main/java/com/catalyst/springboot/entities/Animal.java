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
 * The Animal entity object.
 * @author gwalpole
 */
@Entity
@Table(name = "animal")
public class Animal {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animal_id")
	private Integer animalId;

	@NotNull
	@Size(min=1,max=255)
	@Column(name = "common_name")
	private String commonName;

	@NotNull
	@Size(min=1,max=255)
	@Column(name = "scientific_name")
	private String scientificName;
	
	@Size(min=0,max=255)
	@Column(name = "info_link")
	private String infoLink;

	@Column(name = "food_id")
	private Integer foodId;

	/**
	 * Auto-Generated getter for animalId
	 * @return animalId
	 */
	public Integer getAnimalId() {
		return animalId;
	}

	/**
	 * Auto-Generated setter for AnimalId
	 * @param animalId
	 */
	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	/**
	 * Auto-Generated getter for commonName
	 * @return animalId
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * Auto-Generated setter for AnimalId
	 * @param commonName
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/**
	 * Auto-Generated getter for scientificName
	 * @return scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * Auto-Generated setter for scientificName
	 * @param scientificName
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	/**
	 * Auto-Generated getter for infoLink
	 * @return infoLink
	 */
	public String getInfoLink() {
		return infoLink;
	}

	/**
	 * Auto-Generated setter for infoLink
	 * @param infoLink
	 */
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}

	/**
	 * Auto-Generated getter for foodId
	 * @return foodId
	 */
	public Integer getFoodId() {
		return foodId;
	}

	/**
	 * Auto-Generated setter for foodId
	 * @param foodId
	 */
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	
	
}
