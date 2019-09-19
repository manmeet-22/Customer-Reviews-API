package com.udacity.course3.reviews.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity class to represent a Comment.
 *
 * @author Manmeet
 *
 */
@Entity
@Table(name = "comment")
@JsonIgnoreProperties
public class Comment {
	/** The comment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer commentId;

	/** The comment heading. */
	private String commentHeading;

	/** The comment content. */
	private String commentContent;

	/** The review. */
	@ManyToOne
	private Review review;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
	}

	/**
	 * Gets the comment id.
	 *
	 * @return the comment id
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment id.
	 *
	 * @param commentId the new comment id
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	/**
	 * Gets the comment heading.
	 *
	 * @return the comment heading
	 */
	public String getCommentHeading() {
		return commentHeading;
	}

	/**
	 * Sets the comment heading.
	 *
	 * @param commentHeadng the new comment headng
	 */
	public void setCommentHeadng(String commentHeadng) {
		this.commentHeading = commentHeadng;
	}

	/**
	 * Gets the comment content.
	 *
	 * @return the comment content
	 */
	public String getCommentContent() {
		return commentContent;
	}

	/**
	 * Sets the comment content.
	 *
	 * @param commentContent the new comment content
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public Review getReview() {
		return review;
	}

	/**
	 * Sets the review.
	 *
	 * @param review the new review
	 */
	public void setReview(Review review) {
		this.review = review;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentHeading=" + commentHeading + ", commentContent="
				+ commentContent + ", review=" + review + "]";
	}

}