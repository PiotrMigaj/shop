package pl.migibud.shop.basket.application.port.primary.countitems.model;

import lombok.Builder;

@Builder
public record CountItemsInCartQueryModel(Long cartId) {
}
