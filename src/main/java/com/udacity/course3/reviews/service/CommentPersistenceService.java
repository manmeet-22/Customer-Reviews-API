package com.udacity.course3.reviews.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

/**
 * The Class CommentPersistenceService.
 *
 * @author Manmeet
 */
@Service
public class CommentPersistenceService {
	/** The review repository. */
	@Autowired
	ReviewRepository reviewRepository;

	/** The review mongo repo. */
	@Autowired
	ReviewMongoRepository reviewMongoRepo;

	/** The comment repository. */
	@Autowired
	CommentRepository commentRepository;
	
	/** The logger. */
	static Logger logger = LogManager.getLogger(CommentPersistenceService.class);	

	/**
	 * Persist comment.
	 *
	 * @param reviewId the review id
	 * @param comment the comment
	 * @return the optional
	 */
	public Optional<Comment> persistComment(Integer reviewId, Comment comment) {
		Optional<Comment> commentEntity = Optional.empty();

		Optional<Review> review = reviewRepository.findById(reviewId);
		
		if (review.isPresent()) {
			comment.setReview(review.get());
			commentRepository.save(comment);

				List<ReviewDocument> reviewDocumentList = reviewMongoRepo.findAllByReviewId(Integer.toString(reviewId));
				ReviewDocument reviewDocument = reviewDocumentList.get(0);
				
				List<Comment> comments = reviewDocument.getComments();
				if(comments == null) {
					comments = new ArrayList<Comment>();
				}
				comments.add(comment);
				reviewDocument.setComments(comments);
				reviewMongoRepo.save(reviewDocument);
	
				commentEntity = Optional.of(comment);
		} else {
			logger.info("Review Document with " + reviewId + " is not found!");
		}
		return commentEntity;
	}
}
