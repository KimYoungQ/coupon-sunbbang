package org.coupon.couponsunbbang.domain.product.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.coupon.couponsunbbang.domain.product.dto.response.ProductListResponse;
import org.coupon.couponsunbbang.domain.product.dto.response.ProductResponse;
import org.coupon.couponsunbbang.domain.product.entity.Product;
import org.coupon.couponsunbbang.domain.product.exception.ProductNotFoundException;
import org.coupon.couponsunbbang.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public ProductListResponse getProducts() {
		List<ProductResponse> products = productRepository.findAll()
				                                 .stream()
				                                 .map(ProductResponse::from)
				                                 .toList();

		return new ProductListResponse(products);
	}

	public ProductResponse getProductDetail(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(ProductNotFoundException::new);

		return ProductResponse.from(product);
	}
}
