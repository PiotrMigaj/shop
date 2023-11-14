package pl.migibud.shop.category.application.port.primary;

import lombok.Builder;
import org.springframework.data.domain.Page;

@Builder
public record CategoryWithProductsQueryModel(
    Long categoryId,
    String name,
    String description,
    String slug,
    Page<ProductsQueryModel> products
) {
}
