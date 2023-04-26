package pl.migibud.shop.product.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.product.api.Product;

interface ProductRepository extends JpaRepository<Product,Long> {
}
