package pl.migibud.shop.basket.application.port.secondary;

import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.vo.CartId;

public interface SaveCartPort {
    CartId save(Cart cart);
}
