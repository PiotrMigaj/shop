package pl.migibud.shop.admin.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.admin.api.AdminProduct;

interface AdminProductRepository extends JpaRepository<AdminProduct,Long> {
}
