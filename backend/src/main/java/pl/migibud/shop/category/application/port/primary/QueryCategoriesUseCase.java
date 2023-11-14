package pl.migibud.shop.category.application.port.primary;

import java.util.List;

@FunctionalInterface
public interface QueryCategoriesUseCase {
    
    List<CategoryView> getCategories();
}
