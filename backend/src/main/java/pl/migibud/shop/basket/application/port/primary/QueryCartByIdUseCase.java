package pl.migibud.shop.basket.application.port.primary;

import pl.migibud.shop.basket.domain.vo.CartId;

public interface QueryCartByIdUseCase {

    CartQueryModel queryBy(CartId cartId);
}
