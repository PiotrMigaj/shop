package pl.migibud.shop.category.adapter.secondary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.category.application.port.secondary.QueryCategoryBySlugPort;
import pl.migibud.shop.category.domain.model.Category;

import javax.persistence.EntityNotFoundException;

@Repository
@RequiredArgsConstructor
class QueryCategoryBySlugAdapter implements QueryCategoryBySlugPort {
    
    private final CategoryRepository categoryRepository;
    @Override
    public Category queryBy(String slug) {

        CategoryEntity categoryEntity = categoryRepository
            .findBySlug(slug)
            .orElseThrow(() -> new EntityNotFoundException("There is no category with 'slug': %s".formatted(slug)));
        return CategoryEntityMapper.INSTANCE.mapWithoutProducts(categoryEntity);
    }
}
