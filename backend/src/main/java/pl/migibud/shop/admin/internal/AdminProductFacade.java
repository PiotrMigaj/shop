package pl.migibud.shop.admin.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.admin.api.AdminProduct;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
class AdminProductFacade {

    private final AdminProductRepository adminProductRepository;

    public Page<AdminProduct> getProducts(final Pageable pageable) {
        return adminProductRepository.findAll(pageable);
    }

    public AdminProduct getProduct(final long id) {
        return adminProductRepository.findById(id)
                                     .orElseThrow(() -> new NoSuchElementException("There is no product with ID=%s".formatted(
                                             id)));
    }
    @Transactional
    public AdminProduct createProduct(final AdminProduct adminProduct) {
        return adminProductRepository.save(adminProduct);
    }

    @Transactional
    public AdminProduct updateProduct(final AdminProduct adminProduct) {
        Long productId = adminProduct.getId();
        if (!adminProductRepository.existsById(productId)) {
            throw new NoSuchElementException("There is no product with ID=%s".formatted(productId));
        }
        return adminProductRepository.save(adminProduct);
    }

    @Transactional
    public void deleteProduct(final long id) {
        if (!adminProductRepository.existsById(id)) {
            throw new NoSuchElementException("There is no product with ID=%s".formatted(id));
        }
        adminProductRepository.deleteById(id);
    }
}
