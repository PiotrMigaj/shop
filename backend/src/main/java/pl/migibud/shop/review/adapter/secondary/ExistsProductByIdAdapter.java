package pl.migibud.shop.review.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.review.application.port.secondary.ExistsProductByIdPort;
import pl.migibud.shop.review.domain.vo.ProductId;

@Repository("review.ExistsProductByIdAdapter")
class ExistsProductByIdAdapter implements ExistsProductByIdPort {
    
    private final ProductRepository productRepository;

    public ExistsProductByIdAdapter(@Qualifier("review.ProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean existsBy(ProductId productId) {
        return productRepository.existsById(productId.id());
    }
}
