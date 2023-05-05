package pl.migibud.shop.admin.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.migibud.shop.admin.api.AdminProduct;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
class AdminProductFacade {

    private final AdminProductRepository adminProductRepository;
    Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductRepository.findAll(pageable);
    }

    AdminProduct getProduct(long id) {
        return adminProductRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("There is no product with ID=%s".formatted(id)));
    }
    AdminProduct createProduct(AdminProduct adminProduct) {
        return adminProductRepository.save(adminProduct);
    }

    AdminProduct updateProduct(AdminProduct adminProduct) {
        Long productId = adminProduct.getId();
        if (!adminProductRepository.existsById(productId)){
            throw new NoSuchElementException("There is no product with ID=%s".formatted(productId));
        }
        return adminProductRepository.save(adminProduct);
    }
}
