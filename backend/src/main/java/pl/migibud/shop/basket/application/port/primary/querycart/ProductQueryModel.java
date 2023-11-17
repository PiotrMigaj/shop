package pl.migibud.shop.basket.application.port.primary.querycart;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductQueryModel(
    Long id,
    String name,
    BigDecimal price,
    String currency,
    String image,
    String slug
) {
}
