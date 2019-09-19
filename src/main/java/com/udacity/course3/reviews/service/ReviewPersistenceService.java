package com.udacity.course3.reviews.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

/**
 * The ReviewPersistence Service.
 * 
 * @author Manmeet
 *
 */
@Service
public class ReviewPersistenceService {
	
	/** The product repo. */
	@Autowired
	ProductRepository productRepo;

	/** The review mongo repo. */
	@Autowired
	ReviewMongoRepository reviewMongoRepo;

	/** The review repo. */
	@Autowired
	ReviewRepository reviewRepo;

	/** The logger. */
	static Logger logger = LogManager.getLogger(CommentPersistenceService.class);
	
	/**
	 * Entity to doc convertor.
	 *
	 * @param productId the product id
	 * @param review the review
	 * @return the review document
	 */
	public ReviewDocument entityToDocConvertor(Integer productId, Review review) {
		return new ReviewDocument(Integer.toString(review.getReviewId()), review.getReviewHeading(), review.getReviewContent(), Integer.toString(productId), null);
	}

	/**
	 * Persists Review with JPARepo and MongoRepo using productId.
	 *
	 * @param productId the product id
	 * @param review the review
	 * @return the optional
	 */
	public Optional<ReviewDocument> persistReview(Integer productId, Review review) {
		Optional<ReviewDocument> persistedReview = Optional.empty();
		Optional<Product> product = productRepo.findById(productId);

		if (product.isPresent()) {
			review.setProduct(product.get());
			reviewRepo.save(review);

			ReviewDocument reviewDoc = entityToDocConvertor(productId, review);
			persistedReview = Optional.of(reviewMongoRepo.save(reviewDoc));
			return persistedReview;
		} else {
			logger.info("Product with passed "+ productId + "is not present.");
			return persistedReview;
		}
	}

	/**
	 * Gets the review doc for product.
	 *
	 * @param productId the product id
	 * @return the review doc for product
	 */
	public Optional<List<ReviewDocument>> getReviewDocForProduct(Integer productId) {
		Optional<List<ReviewDocument>> reviewDoc = Optional.empty();
		try {
			List<ReviewDocument> reviewList = reviewMongoRepo.findAllByProductId(Integer.toString(productId));
			reviewDoc = Optional.of(reviewList);
		} catch (Exception e) {
			logger.info("Unable to fetch review doucment for product Id "+ productId );
		}
		return reviewDoc;
	}
}
