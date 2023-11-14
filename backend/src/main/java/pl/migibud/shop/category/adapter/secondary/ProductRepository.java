package pl.migibud.shop.category.adapter.secondary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("category.ProductRepository")
interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    
    Page<ProductEntity> findByCategoryId(Long categoryId, Pageable pageable);
}
