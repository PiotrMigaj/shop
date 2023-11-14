package pl.migibud.shop.product.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("product.ReviewRepository")
interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    List<ReviewEntity> findByProductIdAndModeratedIsTrue(Long productId);
}
