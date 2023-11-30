package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.basket.application.port.primary.countitems.CountItemsInCartUseCase;
import pl.migibud.shop.basket.application.port.primary.countitems.model.CountItemsInCartQueryModel;

@Slf4j
@RestController
@RequiredArgsConstructor
class CountItemsInCartRestAdapter {
    
    private final CountItemsInCartUseCase countItemsInCartUseCase;
    
    @GetMapping("api/v1/cartItems/count/{id}")
    Long countItemsInCart(@PathVariable Long id){
        CountItemsInCartQueryModel countItemsInCartQueryModel = CountItemsInCartQueryModel
            .builder()
            .cartId(id)
            .build();
        return countItemsInCartUseCase.count(countItemsInCartQueryModel);
    }
}
