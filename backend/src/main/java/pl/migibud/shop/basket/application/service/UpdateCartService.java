package pl.migibud.shop.basket.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.basket.application.port.primary.updatecart.UpdateCartUseCase;
import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartCommand;
import pl.migibud.shop.basket.application.port.secondary.QueryCartByIdPort;
import pl.migibud.shop.basket.application.port.secondary.SaveCartPort;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.vo.CartId;

@Service
@RequiredArgsConstructor
class UpdateCartService implements UpdateCartUseCase {
    
    private final QueryCartByIdPort queryCartByIdPort;
    private final SaveCartPort saveCartPort;
    
    @Transactional
    @Override
    public CartId update(UpdateCartCommand updateCartCommand) {

        Cart cart = getCart(updateCartCommand);
        cart.updateCart(CartItemMapper.INSTANCE.map(updateCartCommand.updateCartItemCommands()));
        return saveCartPort.save(cart);
    }

    private Cart getCart(UpdateCartCommand updateCartCommand) {
        CartId cartId = CartId
            .builder()
            .id(updateCartCommand.cartId())
            .build();
        return queryCartByIdPort.queryBy(cartId);
    }
}
