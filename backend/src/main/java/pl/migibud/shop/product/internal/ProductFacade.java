package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.api.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductFacade {

    private final ProductRepository productRepository;

    List<Product> getProducts(){
       return productRepository.findAll();
    }
}
