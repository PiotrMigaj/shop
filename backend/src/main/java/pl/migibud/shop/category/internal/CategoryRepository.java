package pl.migibud.shop.category.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.category.api.Category;

interface CategoryRepository extends JpaRepository<Category,Long> {
    
    Category findBySlug(String slug);
}
