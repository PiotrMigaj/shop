package pl.migibud.shop.basket.application.port.primary;

import pl.migibud.shop.basket.domain.vo.CartId;

public interface AddProductToCartUseCase {
    CartId addProductToCart(AddProductToCartCommand command);
}
