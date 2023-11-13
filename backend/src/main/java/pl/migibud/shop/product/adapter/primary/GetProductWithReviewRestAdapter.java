package pl.migibud.shop.product.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.application.port.primary.GetProductWithReviewUseCase;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewView;

import javax.validation.constraints.Pattern;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
class GetProductWithReviewRestAdapter {
    
    private final GetProductWithReviewUseCase getProductWithReviewUseCase;

    @GetMapping("{slug}")
    ProductWithReviewView getProduct(@PathVariable @Pattern(regexp = "[a-z0-9\\-]+") @Length(max = 255) String slug) {
        return getProductWithReviewUseCase.getProductBy(slug);
    }
}
