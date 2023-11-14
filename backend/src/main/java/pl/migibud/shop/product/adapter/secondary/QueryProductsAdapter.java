package pl.migibud.shop.product.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.product.application.port.primary.QueryProductsView;
import pl.migibud.shop.product.application.port.secondary.QueryProductsPort;

import java.util.List;

@Repository
class QueryProductsAdapter implements QueryProductsPort {
    
    private final ProductRepository productRepository;

    public QueryProductsAdapter(@Qualifier("product.ProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<QueryProductsView> getProducts() {
        return productRepository.findAllBy();
    }
}
