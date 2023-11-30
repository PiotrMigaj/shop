package pl.migibud.shop.basket.application.port.secondary;

import pl.migibud.shop.basket.domain.vo.CartItemId;

public interface DeleteCartItemPort {
    void deleteCartItem(CartItemId cartItemId);
}
