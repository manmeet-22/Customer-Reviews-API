package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface ProductRepository.
 *
 * @author Manmeet
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}