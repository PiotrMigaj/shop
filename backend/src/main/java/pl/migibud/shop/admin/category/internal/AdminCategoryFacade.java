package pl.migibud.shop.admin.category.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.admin.category.api.AdminCategory;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
class AdminCategoryFacade {

    private final AdminCategoryRepository adminCategoryRepository;

    List<AdminCategory> getCategories() {
        return adminCategoryRepository.findAll();
    }

    AdminCategory getCategory(final long id) {
        return adminCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no category with ID=%s".formatted(
                        id)));
    }

    @Transactional
    public AdminCategory createCategory(final AdminCategory adminCategory) {
        return adminCategoryRepository.save(adminCategory);
    }

    @Transactional
    public AdminCategory updateCategory(final AdminCategory adminCategory) {
        Long categoryId = adminCategory.getId();
        if (!adminCategoryRepository.existsById(categoryId)){
            throw new NoSuchElementException("There is no category with ID=%s".formatted(categoryId));
        }
        return adminCategoryRepository.save(adminCategory);
    }

    @Transactional
    public void deleteCategory(final long categoryId) {
        if (!adminCategoryRepository.existsById(categoryId)){
            throw new NoSuchElementException("There is no category with ID=%s".formatted(categoryId));
        }
        adminCategoryRepository.deleteById(categoryId);
    }
}
