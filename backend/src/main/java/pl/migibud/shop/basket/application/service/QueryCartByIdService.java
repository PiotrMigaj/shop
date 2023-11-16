package pl.migibud.shop.basket.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.basket.application.port.primary.CartQueryModel;
import pl.migibud.shop.basket.application.port.primary.QueryCartByIdUseCase;
import pl.migibud.shop.basket.application.port.secondary.QueryCartByIdPort;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.vo.CartId;

@Service
@RequiredArgsConstructor
class QueryCartByIdService implements QueryCartByIdUseCase {
    
    private final QueryCartByIdPort queryCartByIdPort;
    @Override
    public CartQueryModel queryBy(CartId cartId) {
        Cart cart = queryCartByIdPort.queryBy(cartId);
        return null;
    }
}
