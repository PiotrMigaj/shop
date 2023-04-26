package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.api.Product;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
class ProductController {

    private final ProductFacade productFacade;
    @GetMapping
    ResponseEntity<List<Product>> getProducts(){
        List<Product> result = productFacade.getProducts();
        return ResponseEntity.ok(result);
    }
}
