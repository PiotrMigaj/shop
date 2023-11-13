package pl.migibud.shop.product.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.product.application.port.primary.GetProductsView;
import pl.migibud.shop.product.application.port.secondary.GetProductsPort;

import java.util.List;

@Repository
class GetProductsAdapter implements GetProductsPort {
    
    private final ProductRepository productRepository;

    public GetProductsAdapter(@Qualifier("product.ProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetProductsView> getProducts() {
        return productRepository.findAllBy();
    }
}
