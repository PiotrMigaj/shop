package pl.migibud.shop.category.application.port.secondary;

import pl.migibud.shop.category.application.port.primary.CategoryView;

import java.util.List;

@FunctionalInterface
public interface QueryCategoriesPort {

    List<CategoryView> getCategories();
}
