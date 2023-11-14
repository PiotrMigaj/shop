package pl.migibud.shop.category.application.port.secondary;

import pl.migibud.shop.category.domain.model.Category;

@FunctionalInterface
public interface QueryCategoryBySlugPort {

    Category queryBy(String slug);
}
