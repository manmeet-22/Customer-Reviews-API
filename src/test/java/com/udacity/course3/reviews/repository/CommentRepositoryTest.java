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

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;

/**
 * The Class CommentRepositoryTest.
 *
 * @author Manmeet
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
	
	/** The comment repository. */
	@Autowired
	private CommentRepository commentRepository;
	
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
	
	/** The comment. */
	private static Comment comment;

	/**
	 * Inits the product, review and comment.
	 */
	@BeforeClass
	public static void init() {
		product = new Product();
		product.setProductName("Apple Watch Series 4");
		product.setProductPrice(52749.00);
		product.setProductDescription(
				"Watch with (GPS + Cellular, 44mm) - Space Grey Aluminium Case with Black Sport Band");
		review = new Review();
		review.setReviewHeading("Best in class smart watch");
		review.setReviewContent(
				"Truly amazing smart watch from apple. I've used so many smart watches from many popular brands but this is something unique. I really like this watch");
		comment = new Comment();
		comment = new Comment();
		comment.setCommentHeadng("Great review");
		comment.setCommentContent("Thanks for a good review. Gonna buy this watch");
	}

	/**
	 * Test injected components are not null.
	 */
	@Test
	public void testInjectedComponentsAreNotNull() {
		assertThat(productRepository).isNotNull();
		assertThat(commentRepository).isNotNull();
		assertThat(reviewRepository).isNotNull();
	}

	/**
	 * Test save comment in review.
	 */
	@Test
	public void testSaveCommentInReview() {
		Product savedProduct = productRepository.save(product);
		assertThat(savedProduct).isNotNull();
		review.setProduct(savedProduct);
		Review expectedReview = reviewRepository.save(review);
		assertThat(expectedReview).isNotNull();
		Optional<Review> optionalReview = reviewRepository.findById(expectedReview.getReviewId());
		Review actualReview = optionalReview.get();
		assertThat(actualReview).isNotNull();
		assertTrue(actualReview.getReviewId().equals(expectedReview.getReviewId()));
		comment.setReview(expectedReview);
		Comment expectedComment = commentRepository.save(comment);
		Comment actualComment = commentRepository.findById(expectedComment.getCommentId()).get();
		assertTrue(actualComment.getCommentId().equals(expectedComment.getCommentId()));
	}

	/**
	 * Test find all comment by review.
	 */
	@Test
	public void testFindAllCommentByReview() {
		Product savedProduct = productRepository.save(product);
		assertThat(savedProduct).isNotNull();
		review.setProduct(savedProduct);
		Review expectedReview = reviewRepository.save(review);
		assertThat(expectedReview).isNotNull();
		Optional<Review> optionalReview = reviewRepository.findById(expectedReview.getReviewId());
		Review actualReview = optionalReview.get();
		assertThat(actualReview).isNotNull();
		assertTrue(actualReview.getReviewId().equals(expectedReview.getReviewId()));
		comment.setReview(expectedReview);
		Comment expectedComment = commentRepository.save(comment);
		List<Comment> actualCommentList = commentRepository.findAllByReview(expectedReview);
		assertTrue(actualCommentList.size() == 1);
		assertTrue(actualCommentList.get(0).getCommentId().equals(expectedComment.getCommentId()));
	}

}
