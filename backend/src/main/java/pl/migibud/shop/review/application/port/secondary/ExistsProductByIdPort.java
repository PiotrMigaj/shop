package pl.migibud.shop.review.application.port.secondary;

import pl.migibud.shop.review.domain.vo.ProductId;

@FunctionalInterface
public interface ExistsProductByIdPort {

    boolean existsBy(ProductId productId);
}
