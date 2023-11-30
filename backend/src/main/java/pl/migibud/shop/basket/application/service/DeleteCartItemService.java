package pl.migibud.shop.basket.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.basket.application.port.primary.deletecartitem.DeleteCartItemUseCase;
import pl.migibud.shop.basket.application.port.primary.deletecartitem.model.DeleteCartItemCommand;
import pl.migibud.shop.basket.application.port.secondary.DeleteCartItemPort;
import pl.migibud.shop.basket.domain.vo.CartItemId;

@Service
@RequiredArgsConstructor
class DeleteCartItemService implements DeleteCartItemUseCase {
    
    
    private final DeleteCartItemPort deleteCartItemPort;
    
    @Override
    public void delete(DeleteCartItemCommand command) {
        deleteCartItemPort.deleteCartItem(CartItemId
            .builder()
            .id(command.cartItemId())
            .build());
    }
}
