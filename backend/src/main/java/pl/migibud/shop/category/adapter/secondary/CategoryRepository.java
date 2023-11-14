package pl.migibud.shop.category.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.category.application.port.primary.CategoryView;

import java.util.List;
import java.util.Optional;

@Repository("category.CategoryRepository")
interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    
    List<CategoryView> findAllBy();
    Optional<CategoryEntity> findBySlug(String slug); 
}
