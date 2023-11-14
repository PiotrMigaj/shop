package pl.migibud.shop.category.adapter.secondary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.category.application.port.primary.CategoryView;
import pl.migibud.shop.category.application.port.secondary.QueryCategoriesPort;

import java.util.List;

@Repository
@RequiredArgsConstructor
class QueryCategoriesAdapter implements QueryCategoriesPort {
    
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryView> getCategories() {
        return categoryRepository.findAllBy();
    }
}
