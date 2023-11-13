package pl.migibud.shop.product.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.application.port.primary.GetProductsUseCase;
import pl.migibud.shop.product.application.port.primary.GetProductsView;
import pl.migibud.shop.product.application.port.secondary.GetProductsPort;

import java.util.List;

@Service
@RequiredArgsConstructor
class GetProductsService implements GetProductsUseCase {
    
    private final GetProductsPort getProductsPort;
    @Override
    public List<GetProductsView> getProducts() {
        return getProductsPort.getProducts();
    }
}
