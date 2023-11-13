package pl.migibud.shop.product.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.product.application.port.primary.GetProductsView;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewView;

import java.util.List;

@Repository("product.ProductRepository")
interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    
    List<GetProductsView> findAllBy();
    ProductWithReviewView getProductEntityBySlug(String slug);
}
