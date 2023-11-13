package pl.migibud.shop.product.application.port.secondary;

import pl.migibud.shop.product.application.port.primary.GetProductsView;

import java.util.List;

@FunctionalInterface
public interface GetProductsPort {

    List<GetProductsView> getProducts();

}
