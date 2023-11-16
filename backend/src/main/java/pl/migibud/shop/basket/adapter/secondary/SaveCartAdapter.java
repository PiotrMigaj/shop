package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.basket.application.port.secondary.SaveCartPort;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.model.CartItem;
import pl.migibud.shop.basket.domain.vo.CartId;

@Repository
class SaveCartAdapter implements SaveCartPort {

    private final CartRepository cartRepository;

    public SaveCartAdapter(@Qualifier("basket.CartRepository") CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartId save(Cart cart) {

        CartEntity cartEntity = CartEntityMapper.INSTANCE.mapToEntityWithoutCartItems(cart);
        for (CartItem item: cart.getItems()) {
            CartItemEntity cartItemEntity = CartEntityMapper.INSTANCE.mapToEntity(item);
            cartEntity.addCartItemEntity(cartItemEntity);
        }
        return CartId
            .builder()
            .id(cartRepository
                .save(cartEntity)
                .getId())
            .build();
    }
}
