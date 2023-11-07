package pl.migibud.shop.product.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductQueryRepository {
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
}
