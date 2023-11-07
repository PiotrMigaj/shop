package pl.migibud.shop.category.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.category.api.Category;

import javax.validation.constraints.Pattern;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryFacade categoryFacade;
    @GetMapping
    List<Category> getCategories(){
        return categoryFacade.getCategories();
    }

    @GetMapping("{slug}/products")
    CategoryProductDto getCategoriesWithProducts(
        @PathVariable @Pattern(regexp = "[a-z0-9\\-]+") @Length(max = 255) String slug, Pageable pageable) {
        return categoryFacade.getCategoriesWithProducts(slug, pageable);
    }

}
