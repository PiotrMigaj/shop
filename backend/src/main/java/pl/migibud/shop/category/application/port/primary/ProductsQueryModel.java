package pl.migibud.shop.category.application.port.primary;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductsQueryModel(
    Long productId,
    String name,
    String description,
    String fullDescription,
    BigDecimal price,
    String currency,
    String image,
    String slug
) {
}
