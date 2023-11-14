package pl.migibud.shop.product.application.port.secondary;

import pl.migibud.shop.product.domain.model.Product;

@FunctionalInterface
public interface QueryProductWithReviewPort {

    Product queryBy(String slug);

}
