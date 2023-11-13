package pl.migibud.shop.product.application.port.secondary;

import pl.migibud.shop.product.application.port.primary.ProductWithReviewView;

@FunctionalInterface
public interface GetProductWithReviewPort {

    ProductWithReviewView queryBy(String slug);

}
