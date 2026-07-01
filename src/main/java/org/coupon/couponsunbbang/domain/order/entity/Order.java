package org.coupon.couponsunbbang.domain.order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "product_id", nullable = false)
	private Long productId;

	@Column(name = "coupon_issue_id")
	private Long couponIssueId;

	@Column(nullable = false)
	private Integer quantity;

	@Column(name = "original_price", nullable = false)
	private BigDecimal originalPrice;

	@Column(name = "discount_price", nullable = false)
	private BigDecimal discountPrice;

	@Column(name = "final_price", nullable = false)
	private BigDecimal finalPrice;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
}


