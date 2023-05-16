package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.migibud.shop.product.api.Product;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
class ProductFacade {

    private final ProductRepository productRepository;

    Page<Product> getProducts(Pageable pageable){
       return productRepository.findAll(pageable);
    }

    Product getProduct(String slug){
        return productRepository.findBySlug(slug)
                .orElseThrow(()->new NoSuchElementException("There is no product with slug: '%s'".formatted(slug)));
    }
}
