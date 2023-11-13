package pl.migibud.shop.product.application.port.primary;

@FunctionalInterface
public interface GetProductWithReviewUseCase {

    ProductWithReviewView getProductBy(String slug);

}
