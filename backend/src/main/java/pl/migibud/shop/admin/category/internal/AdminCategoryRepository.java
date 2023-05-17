package pl.migibud.shop.admin.category.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.admin.category.api.AdminCategory;

interface AdminCategoryRepository extends JpaRepository<AdminCategory,Long> {
}
