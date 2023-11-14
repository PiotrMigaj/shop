package pl.migibud.shop.category.application.port.secondary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.migibud.shop.category.domain.model.Product;
import pl.migibud.shop.category.domain.vo.CategoryId;

@FunctionalInterface
public interface QueryProductsByCategoryIdPort {

    Page<Product> queryBy(CategoryId categoryId, Pageable pageable);

}
