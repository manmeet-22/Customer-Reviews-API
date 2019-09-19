package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface CommentRepository.
 *
 * @author Manmeet
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Find all by review.
     *
     * @param review the review
     * @return the list
     */
    List<Comment> findAllByReview(Review review);
}