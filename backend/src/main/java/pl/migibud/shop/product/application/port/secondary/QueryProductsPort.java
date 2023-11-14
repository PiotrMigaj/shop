package pl.migibud.shop.product.application.port.secondary;

import pl.migibud.shop.product.application.port.primary.QueryProductsView;

import java.util.List;

@FunctionalInterface
public interface QueryProductsPort {

    List<QueryProductsView> getProducts();

}
