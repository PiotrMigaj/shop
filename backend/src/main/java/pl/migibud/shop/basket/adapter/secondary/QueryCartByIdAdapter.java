package pl.migibud.shop.basket.adapter.secondary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.basket.application.port.secondary.QueryCartByIdPort;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.vo.CartId;

import javax.persistence.EntityNotFoundException;

@Repository
@RequiredArgsConstructor
class QueryCartByIdAdapter implements QueryCartByIdPort {

    private final CartRepository cartRepository;

    @Override
    public Cart queryBy(CartId cartId) {
        return cartRepository
            .findById(cartId.id())
            .map(CartEntityMapper.INSTANCE::map)
            .orElseThrow(() -> new EntityNotFoundException("There is no cart with ID: %s".formatted(cartId.id())));
    }
}
