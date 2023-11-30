package pl.migibud.shop.basket.application.port.primary.addproduct;

import pl.migibud.shop.basket.application.port.primary.addproduct.model.AddProductToCartCommand;
import pl.migibud.shop.basket.domain.vo.CartId;

public interface AddProductToCartUseCase {
    CartId addProductToCart(AddProductToCartCommand command);
}
