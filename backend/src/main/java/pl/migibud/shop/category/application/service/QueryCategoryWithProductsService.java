package pl.migibud.shop.category.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.category.application.port.primary.CategoryWithProductsQueryModel;
import pl.migibud.shop.category.application.port.primary.QueryCategoryWithProductsUseCase;
import pl.migibud.shop.category.application.port.secondary.QueryCategoryBySlugPort;
import pl.migibud.shop.category.application.port.secondary.QueryProductsByCategoryIdPort;
import pl.migibud.shop.category.domain.model.Category;
import pl.migibud.shop.category.domain.model.Product;

@Service
@RequiredArgsConstructor
class QueryCategoryWithProductsService implements QueryCategoryWithProductsUseCase {
    
    private final QueryCategoryBySlugPort queryCategoryBySlugPort;
    private final QueryProductsByCategoryIdPort queryProductsByCategoryIdPort;
    
    @Transactional
    @Override
    public CategoryWithProductsQueryModel queryBy(String slug, Pageable pageable) {
        
        Category category = queryCategoryBySlugPort.queryBy(slug);
        Page<Product> products = queryProductsByCategoryIdPort.queryBy(category.getCategoryId(), pageable);
        return CategoryMapper.INSTANCE.map(category,products,pageable);
    }
}
