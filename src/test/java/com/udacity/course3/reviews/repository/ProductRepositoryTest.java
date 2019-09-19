package com.udacity.course3.reviews.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.Product;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductRepositoryTest.
 *
 * @author Manmeet
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/** The product. */
	private static Product product;

	/**
	 * Inits the product.
	 */
	@BeforeClass
	public static void init() {
		product = new Product();
		product.setProductName("Apple Watch Series 4");
		product.setProductPrice(52749.00);
		product.setProductDescription("Watch with (GPS + Cellular, 44mm) - Space Grey Aluminium Case with Black Sport Band");
	}

	/**
	 * Test injected components are not null.
	 */
	@Test
	public void testInjectedComponentsAreNotNull() {
		assertThat(productRepository).isNotNull();
	}

	/**
	 * Test save product and find product.
	 */
	@Test
	public void testSaveProductAndFindProduct() {
		Product expectedProduct = productRepository.save(product);
		assertThat(expectedProduct).isNotNull();
		Product actualProduct = productRepository.findById(expectedProduct.getProductId()).get();
		assertTrue(expectedProduct.getProductId().equals(actualProduct.getProductId()));
	}

	/**
	 * Test find all products.
	 */
	@Test
	public void testFindAllProducts() {
		Product expectedProduct = productRepository.save(product);
		assertThat(expectedProduct).isNotNull();
		List<Product> actualProductList = productRepository.findAll();
		assertTrue(actualProductList.size() == 1);
		Product actualProduct = actualProductList.get(0);
		assertTrue(expectedProduct.getProductId().equals(actualProduct.getProductId()));
	}
}
