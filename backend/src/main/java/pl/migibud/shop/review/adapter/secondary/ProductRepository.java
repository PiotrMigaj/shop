package pl.migibud.shop.review.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("review.ProductRepository")
interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
