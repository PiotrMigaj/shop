package pl.migibud.shop.category.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.category.application.port.primary.CategoryWithProductsQueryModel;
import pl.migibud.shop.category.application.port.primary.QueryCategoryWithProductsUseCase;

import javax.validation.constraints.Pattern;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
class QueryCategoryWithProductsRestAdapter {
    
    private final QueryCategoryWithProductsUseCase queryCategoryWithProductsUseCase;

    @GetMapping("api/v1/categories/{slug}/products")
    CategoryWithProductsQueryModel getCategoriesWithProducts(
        @PathVariable @Pattern(regexp = "[a-z0-9\\-]+") @Length(max = 255) String slug, Pageable pageable) {
        return queryCategoryWithProductsUseCase.queryBy(slug, pageable);
    }

}
