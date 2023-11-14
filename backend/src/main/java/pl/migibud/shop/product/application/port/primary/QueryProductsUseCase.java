package pl.migibud.shop.product.application.port.primary;

import java.util.List;

@FunctionalInterface
public interface QueryProductsUseCase {
    List<QueryProductsView> getProducts();
}
