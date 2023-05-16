package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.api.Product;

import javax.validation.constraints.Pattern;

@Slf4j
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Validated
class ProductController {

    private final ProductFacade productFacade;

    @GetMapping
    Page<Product> getProducts(Pageable pageable) {
        return productFacade.getProducts(pageable);
    }

    @GetMapping("{slug}")
    Product getProduct(@PathVariable @Pattern(regexp = "[a-z0-9\\-]+") @Length(max = 255) String slug) {
        return productFacade.getProduct(slug);
    }

}
