package pl.migibud.shop.product.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.product.api.Product;

import java.util.Optional;

interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findBySlug(String slug);
}
