package com.udacity.course3.reviews.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

	// TODO: Wire needed JPA repositories here
	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	CommentRepository commentRepository;

	/**
	 * Creates a comment for a review.
	 *
	 * 1. Add argument for comment entity. Use {@link RequestBody} annotation. 2.
	 * Check for existence of review. 3. If review not found, return NOT_FOUND. 4.
	 * If found, save comment.
	 *
	 * @param reviewId The id of the review.
	 */
	@RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
	public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
			@RequestBody Comment comment) {
		Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
		if (reviewOptional.isPresent()) {
			comment.setReview(reviewOptional.get());
			return ResponseEntity.ok(commentRepository.save(comment));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * List comments for a review.
	 *
	 * 2. Check for existence of review. 3. If review not found, return NOT_FOUND.
	 * 4. If found, return list of comments.
	 *
	 * @param reviewId The id of the review.
	 */
	@RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
		Review review = new Review();
		review.setReviewId(reviewId);
		if (commentRepository.findAllByReview(review).size() == 0) {
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(commentRepository.findAllByReview(review));
	}
}