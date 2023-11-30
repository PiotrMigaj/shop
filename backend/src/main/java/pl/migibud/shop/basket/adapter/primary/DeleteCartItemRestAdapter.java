package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.basket.application.port.primary.deletecartitem.DeleteCartItemUseCase;
import pl.migibud.shop.basket.application.port.primary.deletecartitem.model.DeleteCartItemCommand;

@Slf4j
@RestController
@RequiredArgsConstructor
class DeleteCartItemRestAdapter {
    
    private final DeleteCartItemUseCase deleteCartItemUseCase;
    
    @DeleteMapping("api/v1/cartItems/{id}")
    void deleteCartItem(@PathVariable Long id){
        DeleteCartItemCommand deleteCartItemCommand = DeleteCartItemCommand
            .builder()
            .cartItemId(id)
            .build();
        deleteCartItemUseCase.delete(deleteCartItemCommand);
    }
}
