package pl.migibud.shop.product.api;

import lombok.Builder;
import pl.migibud.shop.review.api.ReviewDto;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProductWithReviewDto(
    Long id,
    String name,
    Long categoryId,
    String description,
    String fullDescription,
    BigDecimal price,
    String currency,
    String image,
    String slug,
    List<ReviewDto> reviews
) {
}
