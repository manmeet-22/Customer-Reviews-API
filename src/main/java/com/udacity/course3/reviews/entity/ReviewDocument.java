package com.udacity.course3.reviews.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Review Document for MangoDB.
 *
 * @author Manmeet
 */
@Document(collection = "review")
public class ReviewDocument {

	/** The id. */
	@Id
	private String id;

	/** The review id. */
	private String reviewId;

	/** The review heading. */
	private String reviewHeading;

	/** The review content. */
	private String reviewContent;

	/** The product id. */
	private String productId;

	/** The comments. */
	List<Comment> comments;

	/**
	 * Instantiates a new review document.
	 */
	public ReviewDocument() {
	}

	/**
	 * Instantiates a new review document.
	 *
	 * @param id the id
	 * @param reviewId the review id
	 * @param reviewHeading the review heading
	 * @param reviewContent the review content
	 * @param productId the product id
	 * @param comments the comments
	 */
	public ReviewDocument(String id, String reviewId, String reviewHeading, String reviewContent, String productId,
			List<Comment> comments) {
		super();
		this.id = id;
		this.reviewId = reviewId;
		this.reviewHeading = reviewHeading;
		this.reviewContent = reviewContent;
		this.productId = productId;
		this.comments = comments;
	}

	/**
	 * Instantiates a new review document.
	 *
	 * @param reviewId the review id
	 * @param reviewHeading the review heading
	 * @param reviewContent the review content
	 * @param productId the product id
	 * @param comments the comments
	 */
	public ReviewDocument(String reviewId, String reviewHeading, String reviewContent, String productId,
			List<Comment> comments) {
		super();
		this.reviewId = reviewId;
		this.reviewHeading = reviewHeading;
		this.reviewContent = reviewContent;
		this.productId = productId;
		this.comments = comments;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public String getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(String reviewId) {
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
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
