package pl.migibud.shop.basket.application.port.primary.deletecartitem.model;

import lombok.Builder;

@Builder
public record DeleteCartItemCommand(Long cartItemId) {
}
