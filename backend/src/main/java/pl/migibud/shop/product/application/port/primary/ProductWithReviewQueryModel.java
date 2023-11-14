package pl.migibud.shop.product.application.port.primary;

import java.math.BigDecimal;
import java.util.List;

public record ProductWithReviewQueryModel(
    Long id,
    String name,
    Long categoryId,
    String description,
    String fullDescription,
    BigDecimal price,
    String currency,
    String image,
    String slug,
    List<ReviewQueryModel> reviews
) {
}

