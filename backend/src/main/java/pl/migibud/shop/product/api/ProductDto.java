package pl.migibud.shop.product.api;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(
    Long id,
    String name,
    String description,
    BigDecimal price,
    String currency,
    String image,
    String slug
) {
}
