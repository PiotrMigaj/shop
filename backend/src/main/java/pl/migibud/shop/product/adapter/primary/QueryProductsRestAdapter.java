package pl.migibud.shop.product.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.application.port.primary.QueryProductsUseCase;
import pl.migibud.shop.product.application.port.primary.QueryProductsView;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
class QueryProductsRestAdapter {

    private final QueryProductsUseCase queryProductsUseCase;
    
    @GetMapping("api/v1/products")
    List<QueryProductsView> getProducts(){
        return queryProductsUseCase.getProducts();
    }

}
