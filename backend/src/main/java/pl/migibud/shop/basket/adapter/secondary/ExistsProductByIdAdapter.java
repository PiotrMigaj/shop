package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.basket.application.port.secondary.ExistsProductByIdPort;
import pl.migibud.shop.basket.domain.vo.ProductId;

@Repository("basket.ExistsProductByIdAdapter")
class ExistsProductByIdAdapter implements ExistsProductByIdPort {

    public ExistsProductByIdAdapter(@Qualifier("basket.ProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;
    @Override
    public boolean existsBy(ProductId productId) {
        return productRepository.existsById(productId.id());
    }
}
