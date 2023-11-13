package pl.migibud.shop.product.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewView;
import pl.migibud.shop.product.application.port.secondary.GetProductWithReviewPort;

@Repository
class GetProductWithReviewAdapter implements GetProductWithReviewPort {

    private final ProductRepository productRepository;

    public GetProductWithReviewAdapter(@Qualifier("product.ProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductWithReviewView queryBy(String slug) {
        return productRepository.getProductEntityBy(slug);
    }
}
