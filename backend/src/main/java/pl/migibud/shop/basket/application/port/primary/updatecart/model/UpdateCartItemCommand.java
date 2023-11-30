package pl.migibud.shop.basket.application.port.primary.updatecart.model;

import lombok.Builder;

@Builder
public record UpdateCartItemCommand(
    Long cartItemId,
    int quantity
) {
}
