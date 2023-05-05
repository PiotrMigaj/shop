package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.api.Product;

@Slf4j
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
class ProductController {

    private final ProductFacade productFacade;
    @GetMapping
    Page<Product> getProducts(Pageable pageable){
        return productFacade.getProducts(pageable);
    }
}
