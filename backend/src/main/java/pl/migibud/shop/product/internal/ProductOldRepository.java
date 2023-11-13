package pl.migibud.shop.product.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.product.api.Product;
import pl.migibud.shop.product.api.ProductQueryRepository;

import java.util.Optional;

interface ProductOldRepository extends ProductQueryRepository, JpaRepository<Product,Long> {
    Optional<Product> findBySlug(String slug);
}
