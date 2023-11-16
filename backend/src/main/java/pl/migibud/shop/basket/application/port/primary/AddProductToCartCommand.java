package pl.migibud.shop.basket.application.port.primary;

import lombok.Builder;

@Builder
public record AddProductToCartCommand(
    Long cardId,
    Long productId,
    int quantity
) {
}
