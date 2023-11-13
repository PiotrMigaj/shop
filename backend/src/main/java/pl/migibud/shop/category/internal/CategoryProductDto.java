package pl.migibud.shop.category.internal;

import lombok.Builder;
import pl.migibud.shop.category.api.Category;

@Builder
record CategoryProductDto(Category category) {
}
