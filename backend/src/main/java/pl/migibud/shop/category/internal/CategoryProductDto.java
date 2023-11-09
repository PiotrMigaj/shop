package pl.migibud.shop.category.internal;

import lombok.Builder;
import org.springframework.data.domain.Page;
import pl.migibud.shop.category.api.Category;
import pl.migibud.shop.product.api.ProductDto;

@Builder
record CategoryProductDto(Category category, Page<ProductDto> products) {
}
