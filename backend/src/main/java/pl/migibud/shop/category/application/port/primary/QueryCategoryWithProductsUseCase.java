package pl.migibud.shop.category.application.port.primary;

import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface QueryCategoryWithProductsUseCase {
    CategoryWithProductsQueryModel queryBy(String slug, Pageable pageable);
}
