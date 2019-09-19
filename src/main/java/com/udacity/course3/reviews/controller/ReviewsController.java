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

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.service.ReviewPersistenceService;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

	/** The review persistence service. */
	@Autowired
	ReviewPersistenceService reviewPersistenceService;
	/**
	 * Creates a review for a product.
	 * <p>
	 * 1. Add argument for review entity. Use {@link RequestBody} annotation. 2.
	 * Check for existence of product. 3. If product not found, return NOT_FOUND. 4.
	 * If found, save review.
	 *
	 * @param productId The id of the product.
	 * @param review    the review
	 * @return The created review or 404 if product id is not found.
	 */
	@RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
	public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId,
			@RequestBody Review review) {
		Optional<ReviewDocument> reviewDocument = reviewPersistenceService.persistReview(productId, review);
		if (reviewDocument.isPresent()) {
			return ResponseEntity.ok(reviewDocument.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * List reviews for product.
	 *
	 * @param productId the product id
	 * @return the response entity
	 */
	@RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<?> listReviewsForProduct(@PathVariable("productId") Integer productId) {
		Optional<List<ReviewDocument>> reviewDocument = reviewPersistenceService.getReviewDocForProduct(productId);
		if (reviewDocument.get().isEmpty()) {
			return ResponseEntity.notFound().build();		
		}
		return ResponseEntity.ok(reviewDocument.get());
	}
}