package pl.migibud.shop.category.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.category.application.port.primary.CategoryView;
import pl.migibud.shop.category.application.port.primary.QueryCategoriesUseCase;
import pl.migibud.shop.category.application.port.secondary.QueryCategoriesPort;

import java.util.List;

@Service
@RequiredArgsConstructor
class QueryCategoriesService implements QueryCategoriesUseCase {
    
    private final QueryCategoriesPort queryCategoriesPort;
    @Override
    public List<CategoryView> getCategories() {
        return queryCategoriesPort.getCategories();
    }
}
