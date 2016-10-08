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
 * The Category entity object.
 * @author gwalpole
 */
@Entity
@Table(name = "food_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;

	@NotNull
	@Size(min=1,max=255)
	@Column(name = "category")
	private String category;

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
	 * Auto-Generated getter for category
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Auto-Generated setter for category
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}	
	
}
