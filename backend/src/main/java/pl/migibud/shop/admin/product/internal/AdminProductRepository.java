package pl.migibud.shop.admin.product.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.admin.product.api.AdminProduct;

interface AdminProductRepository extends JpaRepository<AdminProduct,Long> {
}
