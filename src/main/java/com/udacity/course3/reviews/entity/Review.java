package com.udacity.course3.reviews.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity class to represent a Review.
 *
 * @author Manmeet
 *
 */
@Entity
@Table(name = "review")
@JsonIgnoreProperties
public class Review {

	/** The review id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;

	/** The review heading. */
	private String reviewHeading;

	/** The review content. */
	private String reviewContent;

	/** The product. */
	@ManyToOne
	private Product product;

	/**
	 * Instantiates a new review.
	 */
	public Review() {
	}

    /**
     * Instantiates a new review.
     *
     * @param reviewId the review id
     */
    public Review(Integer reviewId) {
        this.reviewId = reviewId;
    }
    
	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public Integer getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Gets the review heading.
	 *
	 * @return the review heading
	 */
	public String getReviewHeading() {
		return reviewHeading;
	}

	/**
	 * Sets the review heading.
	 *
	 * @param reviewHeading the new review heading
	 */
	public void setReviewHeading(String reviewHeading) {
		this.reviewHeading = reviewHeading;
	}

	/**
	 * Gets the review content.
	 *
	 * @return the review content
	 */
	public String getReviewContent() {
		return reviewContent;
	}

	/**
	 * Sets the review content.
	 *
	 * @param reviewContent the new review content
	 */
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewHeading=" + reviewHeading + ", reviewContent=" + reviewContent
				+ ", product=" + product + "]";
	}
	
	
}