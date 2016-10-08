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
 * The FavoriteFood entity object.
 * @author gwalpole
 */
@Entity
@Table(name = "food")
public class FavoriteFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Integer foodId;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
	@NotNull
	@Size(min=0,max=255)
	@Column(name = "name")
	private String name;	
	
	@Size(min=0,max=255)
	@Column(name = "vendor")
	private String vendor;

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

	/**
	 * Auto-Generated getter for categoryId
	 * @return categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * Auto-Generated setter for categoryId
	 * @param categoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Auto-Generated getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Auto-Generated setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Auto-Generated getter for vendor
	 * @return vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * Auto-Generated setter for 
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
}
