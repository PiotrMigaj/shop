package pl.migibud.shop.product.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.application.port.primary.QueryProductsUseCase;
import pl.migibud.shop.product.application.port.primary.QueryProductsView;
import pl.migibud.shop.product.application.port.secondary.QueryProductsPort;

import java.util.List;

@Service
@RequiredArgsConstructor
class QueryProductsService implements QueryProductsUseCase {
    
    
    private final QueryProductsPort queryProductsPort;
    @Override
    public List<QueryProductsView> getProducts() {
        return queryProductsPort.getProducts();
    }
}
