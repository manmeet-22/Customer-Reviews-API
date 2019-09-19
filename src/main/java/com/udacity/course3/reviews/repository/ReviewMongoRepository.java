package com.udacity.course3.reviews.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udacity.course3.reviews.entity.ReviewDocument;

/**
 * ReviewMongoDB repository.
 *
 * @author Manmeet
 *
 */
@Repository
public interface ReviewMongoRepository extends MongoRepository<ReviewDocument, String> {
	
	/**
	 * Find all by review id.
	 *
	 * @param reviewId the review id
	 * @return the list
	 */
	List<ReviewDocument> findAllByReviewId(String reviewId);
	
	/**
	 * Find all by product id.
	 *
	 * @param productId the product id
	 * @return the list
	 */
	List<ReviewDocument> findAllByProductId(String productId);
}
