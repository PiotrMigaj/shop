package pl.migibud.shop.product.application.port.primary;

import java.util.List;

@FunctionalInterface
public interface GetProductsUseCase {
    List<GetProductsView> getProducts();
}
