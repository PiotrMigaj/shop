package pl.migibud.shop.category.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.category.application.port.primary.CategoryView;
import pl.migibud.shop.category.application.port.primary.QueryCategoriesUseCase;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
class QueryCategoriesRestAdapter {

    private final QueryCategoriesUseCase queryCategoriesUseCase;
    
    @GetMapping("api/v1/categories")
    List<CategoryView> getCategories(){
        return queryCategoriesUseCase.getCategories();
    }

}
