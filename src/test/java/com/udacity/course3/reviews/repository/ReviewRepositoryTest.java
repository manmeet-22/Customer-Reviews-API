package com.udacity.course3.reviews.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;

/**
 * The Class ReviewRepositoryTest.
 *
 * @author Manmeet
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {
	
	/** The review repository. */
	@Autowired
	private ReviewRepository reviewRepository;
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/** The product. */
	private static Product product;
	
	/** The review. */
	private static Review review;

	/**
	 * Inits the product and review.
	 */
	@BeforeClass
	public static void init() {
		product = new Product();
		product.setProductName("Apple Watch Series 4");
		product.setProductPrice(52749.00);
		product.setProductDescription("Watch with (GPS + Cellular, 44mm) - Space Grey Aluminium Case with Black Sport Band");
		review = new Review();
		review.setReviewHeading("Best in class smart watch");
		review.setReviewContent("Truly amazing smart watch from apple. I've used so many smart watches from many popular brands but this is something unique. I really like this watch");
	}

	/**
	 * Test injected components are not null.
	 */
	@Test
	public void testInjectedComponentsAreNotNull() {
		assertThat(productRepository).isNotNull();
		assertThat(reviewRepository).isNotNull();
	}

	/**
	 * Test save review for product.
	 */
	@Test
	public void testSaveReviewForProduct() {
		Product savedProduct = productRepository.save(product);
		review.setProduct(savedProduct);
		Review expectedReview = reviewRepository.save(review);
		assertThat(expectedReview).isNotNull();
		Optional<Review> optionalReview = reviewRepository.findById(expectedReview.getReviewId());
		Review actualReview = optionalReview.get();
		assertThat(actualReview).isNotNull();
		assertTrue(actualReview.getReviewId().equals(expectedReview.getReviewId()));
	}

	/**
	 * Test find all review by product.
	 */
	@Test
	public void testFindAllReviewByProduct() {
		Product savedProduct = productRepository.save(product);
		review.setProduct(savedProduct);
		Review expectedReview = reviewRepository.save(review);
		assertThat(expectedReview).isNotNull();
		List<Review> actualReviewList = reviewRepository.findAll();
		assertTrue(actualReviewList.size() == 1);
		Review actualReview = actualReviewList.get(0);
		assertThat(expectedReview.getReviewId().equals(actualReview.getReviewId()));
	}

}
