package pl.migibud.shop.category.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.category.api.Category;
import pl.migibud.shop.product.api.Product;
import pl.migibud.shop.product.api.ProductMapper;
import pl.migibud.shop.product.api.ProductQueryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
class CategoryFacade {

    private final CategoryRepository categoryRepository;
    private final ProductQueryRepository productQueryRepository;
    private final ProductMapper productMapper;

    List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryProductDto getCategoriesWithProducts(String slug, Pageable pageable) {

        Category category = categoryRepository.findBySlug(slug);
        Page<Product> products = productQueryRepository.findByCategoryId(category.getId(), pageable);
        return CategoryProductDto
            .builder()
            .category(category)
            .products(new PageImpl<>(productMapper.map(products.getContent()), pageable, products.getTotalElements()))
            .build();
    }
}
