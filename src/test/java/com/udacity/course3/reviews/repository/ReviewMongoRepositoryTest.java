package com.udacity.course3.reviews.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entity.ReviewDocument;

/**
 * The Class ReviewMongoRepositoryTest.
 *
 * @author Manmeet
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class ReviewMongoRepositoryTest {

	/** The mongo template. */
	@Autowired
	MongoTemplate mongoTemplate;

	/** The review mongo repository. */
	@Autowired
	ReviewMongoRepository reviewMongoRepository;

	/** The Constant REVIEW_ID. */
	private static final String REVIEW_ID = "1";
	
	/** The Constant REVIEW_HEADING. */
	private static final String REVIEW_HEADING = "Best in class smart watch";
	
	/** The Constant REVIEW_CONTENT. */
	private static final String REVIEW_CONTENT = "Truly amazing smart watch from apple. I've used so many smart watches from many popular brands but this is something unique. I really like this watch";

	
	/**
	 * Test db connectivity.
	 */
	@Test
	public void testDbConnectivity() {
		DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();

		mongoTemplate.save(objectToSave, "collection");
		assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key").containsOnly("value");
	}

	/**
	 * Save review document.
	 */
	@Test
	public void testSaveReviewDocument() {

		ReviewDocument demoReview;
		demoReview = new ReviewDocument();
		demoReview.setReviewId(REVIEW_ID);
		demoReview.setReviewHeading(REVIEW_HEADING);
		demoReview.setReviewContent(REVIEW_CONTENT);
		reviewMongoRepository.save(demoReview);

		List<ReviewDocument> expectedReviewList = reviewMongoRepository.findAllByReviewId(REVIEW_ID);
		ReviewDocument expectedReview = expectedReviewList.get(0);
		assertThat(expectedReview.getReviewHeading().equals(REVIEW_HEADING));
		assertThat(expectedReview.getReviewContent().equals(REVIEW_CONTENT));
	}

	/**
	 * Find all reviews using product id.
	 */
	@Test
	public void testFindAllReviewsUsingProductId() {
		ReviewDocument demoReview;
		demoReview = new ReviewDocument();
		demoReview.setReviewId(REVIEW_ID);
		demoReview.setReviewHeading(REVIEW_HEADING);
		demoReview.setReviewContent(REVIEW_CONTENT);
		demoReview.setProductId("1");

		reviewMongoRepository.save(demoReview);

		List<ReviewDocument> expectedReviews = reviewMongoRepository.findAllByProductId("1");
		assertTrue(expectedReviews.isEmpty() == false);
		assertThat(expectedReviews.get(0).getReviewHeading().equals(REVIEW_HEADING));
		assertThat(expectedReviews.get(0).getReviewContent().equals(REVIEW_CONTENT));
	}

}
