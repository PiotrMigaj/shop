package pl.migibud.shop.product.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.product.application.port.primary.QueryProductsView;

import java.util.List;
import java.util.Optional;

@Repository("product.ProductRepository")
interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    
    List<QueryProductsView> findAllBy();
    
    Optional<ProductEntity> findBySlug(String slug);
}
