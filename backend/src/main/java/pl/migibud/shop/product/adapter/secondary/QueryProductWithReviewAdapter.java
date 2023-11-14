package pl.migibud.shop.product.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.product.application.port.secondary.QueryProductWithReviewPort;
import pl.migibud.shop.product.domain.model.Product;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
class QueryProductWithReviewAdapter implements QueryProductWithReviewPort {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public QueryProductWithReviewAdapter(
        @Qualifier("product.ProductRepository") ProductRepository productRepository,
        @Qualifier("product.ReviewRepository") ReviewRepository reviewRepository
    ) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }
    
    @Transactional(readOnly = true)
    @Override
    public Product queryBy(String slug) {

        ProductEntity productEntity = productRepository
            .findBySlug(slug)
            .orElseThrow(() -> new EntityNotFoundException("There is no product with 'slug': %s".formatted(slug)));
        List<ReviewEntity> reviewEntities = reviewRepository.findByProductIdAndModeratedIsTrue(productEntity.getId());
        return ProductEntityMapper.INSTANCE.map(productEntity,reviewEntities);
    }
}
