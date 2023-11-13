package pl.migibud.shop.product.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.application.port.primary.GetProductsUseCase;
import pl.migibud.shop.product.application.port.primary.GetProductsView;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
class GetProductsRestAdapter {

    private final GetProductsUseCase getProductsUseCase;
    
    @GetMapping("api/v1/products")
    List<GetProductsView> getProducts(){
        return getProductsUseCase.getProducts();
    }

}
