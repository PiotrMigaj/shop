package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.basket.application.port.primary.querycart.CartQueryModel;
import pl.migibud.shop.basket.application.port.primary.querycart.QueryCartByIdUseCase;
import pl.migibud.shop.basket.domain.vo.CartId;

@Slf4j
@RestController
@RequiredArgsConstructor
class QueryCartByIdRestAdapter {

    private final QueryCartByIdUseCase queryCartByIdUseCase;
    
    @GetMapping("api/v1/carts/{id}")
    CartQueryModel getCartById(@PathVariable Long id){
        return queryCartByIdUseCase.queryBy(CartId.builder().id(id).build());
    }

}
