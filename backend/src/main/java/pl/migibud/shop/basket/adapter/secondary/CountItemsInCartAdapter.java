package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.basket.application.port.secondary.CountItemsInCartPort;
import pl.migibud.shop.basket.domain.vo.CartId;

@Repository
class CountItemsInCartAdapter implements CountItemsInCartPort {

    private final CartItemRepository cartItemRepository;

    public CountItemsInCartAdapter(@Qualifier("basket.CartItemRepository") CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    
    @Override
    public Long count(CartId cartId) {
        return cartItemRepository.countByCartId(cartId.id());
    }
}
