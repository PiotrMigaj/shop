package pl.migibud.shop.basket.application.port.secondary;

import pl.migibud.shop.basket.domain.vo.CartId;

public interface CountItemsInCartPort {

    Long count(CartId cartId);
}

