package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("basket.ProductRepository")
interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
