package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.basket.application.port.primary.updatecart.UpdateCartUseCase;
import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartCommand;
import pl.migibud.shop.basket.domain.vo.CartId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
class UpdateCartRestAdapter {

    private final UpdateCartUseCase updateCartUseCase;
    
    @PutMapping("api/v1/carts/{id}/update")
    CartId updateCard(@PathVariable Long id,@RequestBody UpdateCartRequest updateCartRequest){
        UpdateCartCommand updateCartCommand = UpdateCartMapper.INSTANCE.map(id, updateCartRequest);
        return updateCartUseCase.update(updateCartCommand);
    }
    
    record UpdateCartRequest(
        List<UpdateCartItemRequest> updateCartItemRequests
    ){
    }
    
    record UpdateCartItemRequest(
        @NotNull @Min(1) Long cartItemId,
        @Min(1) int quantity
    ){}
    

    
    

}
