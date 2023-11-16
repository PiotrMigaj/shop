package pl.migibud.shop.basket.application.port.secondary;

import pl.migibud.shop.basket.domain.vo.ProductId;

public interface ExistsProductByIdPort {

    boolean existsBy(ProductId productId);
}
