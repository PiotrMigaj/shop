package pl.migibud.shop.product.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewQueryModel;
import pl.migibud.shop.product.application.port.primary.QueryProductWithReviewUseCase;

import javax.validation.constraints.Pattern;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
class QueryProductWithReviewRestAdapter {
    
    private final QueryProductWithReviewUseCase queryProductWithReviewUseCase;

    @GetMapping("api/v1/products/{slug}")
    ProductWithReviewQueryModel getProduct(@PathVariable @Pattern(regexp = "[a-z0-9\\-]+") @Length(max = 255) String slug) {
        return queryProductWithReviewUseCase.queryProductBy(slug);
    }
}
