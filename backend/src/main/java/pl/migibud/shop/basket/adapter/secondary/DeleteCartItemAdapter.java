package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.basket.application.port.secondary.DeleteCartItemPort;
import pl.migibud.shop.basket.domain.vo.CartItemId;

import javax.persistence.EntityNotFoundException;

@Repository
class DeleteCartItemAdapter implements DeleteCartItemPort {
    
    private final CartItemRepository cartItemRepository;

    public DeleteCartItemAdapter(@Qualifier("basket.CartItemRepository") CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public void deleteCartItem(CartItemId cartItemId) {
        if (!cartItemRepository.existsById(cartItemId.id())){
            throw new EntityNotFoundException("There is no cart item with ID: %s".formatted(cartItemId.id()));
        }
        cartItemRepository.deleteById(cartItemId.id());
    }
}
