package pl.migibud.shop.basket.application.port.primary.querycart.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CartItemQueryModel(
    Long id,
    int quantity,
    ProductQueryModel productQueryModel,
    BigDecimal lineValue
) {
}
