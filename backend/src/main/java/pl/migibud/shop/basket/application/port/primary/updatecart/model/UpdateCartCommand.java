package pl.migibud.shop.basket.application.port.primary.updatecart.model;

import lombok.Builder;

import java.util.List;

@Builder
public record UpdateCartCommand(
    Long cartId,
    List<UpdateCartItemCommand> updateCartItemCommands
) {
}
