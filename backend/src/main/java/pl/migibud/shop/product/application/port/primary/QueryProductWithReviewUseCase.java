package pl.migibud.shop.product.application.port.primary;

@FunctionalInterface
public interface QueryProductWithReviewUseCase {

    ProductWithReviewQueryModel queryProductBy(String slug);

}
