package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.basket.application.port.primary.addproduct.AddProductToCartCommand;
import pl.migibud.shop.basket.application.port.primary.addproduct.AddProductToCartUseCase;
import pl.migibud.shop.basket.domain.vo.CartId;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequiredArgsConstructor
class AddProductToCartRestAdapter {

    private final AddProductToCartUseCase addProductToCartUseCase;
    @PutMapping("api/v1/carts/{id}")
    CartId addProductToCart(@PathVariable Long id,@RequestBody @Valid AddProductToCartRequest request){
        AddProductToCartCommand command = AddProductToCartCommand
            .builder()
            .cardId(id)
            .productId(request.productId())
            .quantity(request.quantity())
            .build();
        return addProductToCartUseCase.addProductToCart(command);
    }
    
    record AddProductToCartRequest(
        @NotNull @Min(value = 0) Long productId,
        @Min(value = 1) int quantity
    ){
    }

}
