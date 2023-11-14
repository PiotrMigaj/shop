package pl.migibud.shop.product.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewQueryModel;
import pl.migibud.shop.product.application.port.primary.QueryProductWithReviewUseCase;
import pl.migibud.shop.product.application.port.secondary.QueryProductWithReviewPort;
import pl.migibud.shop.product.domain.model.Product;

@Service
@RequiredArgsConstructor
class QueryProductWithReviewService implements QueryProductWithReviewUseCase {
    
    private final QueryProductWithReviewPort queryProductWithReviewPort;
    @Override
    public ProductWithReviewQueryModel queryProductBy(String slug) {
        Product product = queryProductWithReviewPort.queryBy(slug);
        return ProductMapper.INSTANCE.map(product);
    }
}
