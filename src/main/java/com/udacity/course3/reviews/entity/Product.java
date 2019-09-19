package com.udacity.course3.reviews.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity class to represent a Product.
 *
 * @author Manmeet
 *
 */
@Entity
@Table(name = "product")
@JsonIgnoreProperties
public class Product {

	/** The product id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer productId; 
	
	/** The product name. */
	private String productName;

	/** The product description. */
	private String productDescription;

	/** The product price. */
	private double productPrice;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + "]";
	}	
	
	
}