package pl.migibud.shop.category.adapter.secondary;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.category.application.port.secondary.QueryProductsByCategoryIdPort;
import pl.migibud.shop.category.domain.model.Product;
import pl.migibud.shop.category.domain.vo.CategoryId;

@Repository
@RequiredArgsConstructor
class QueryProductsByCategoryIdAdapter implements QueryProductsByCategoryIdPort {

    private final ProductRepository productRepository;
    
    @Override
    public Page<Product> queryBy(CategoryId categoryId, Pageable pageable) {
        Page<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId.id(), pageable);
        return ProductEntityMapper.INSTANCE.map(productEntities,pageable);
    }
}
