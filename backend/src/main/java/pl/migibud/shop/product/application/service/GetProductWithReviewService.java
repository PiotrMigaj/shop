package pl.migibud.shop.product.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.application.port.primary.GetProductWithReviewUseCase;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewView;
import pl.migibud.shop.product.application.port.secondary.GetProductWithReviewPort;

@Service
@RequiredArgsConstructor
class GetProductWithReviewService implements GetProductWithReviewUseCase {
    
    private final GetProductWithReviewPort getProductWithReviewPort;
    @Override
    public ProductWithReviewView getProductBy(String slug) {
        return getProductWithReviewPort.queryBy(slug);
    }
}
