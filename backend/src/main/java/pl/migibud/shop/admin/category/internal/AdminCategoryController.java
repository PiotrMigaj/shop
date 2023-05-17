package pl.migibud.shop.admin.category.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.migibud.shop.admin.category.api.AdminCategory;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("admin/categories")
@RequiredArgsConstructor
class AdminCategoryController {

    private static final Long EMPTY_ID = null;
    private final AdminCategoryFacade adminCategoryFacade;
    private final AdminCategoryMapper adminCategoryMapper;

    @GetMapping
    List<AdminCategory> getCategories(){
        return adminCategoryFacade.getCategories();
    }
    @GetMapping("{id}")
    AdminCategory getCategory(@PathVariable Long id){
        return adminCategoryFacade.getCategory(id);
    }
    @PostMapping
    ResponseEntity<AdminCategory> createCategory(@RequestBody @Valid AdminCategoryDto adminCategoryDto){
        AdminCategory adminCategory = adminCategoryMapper.toAdminCategory(EMPTY_ID, adminCategoryDto);
        AdminCategory result = adminCategoryFacade.createCategory(adminCategory);
        return ResponseEntity.created(URI.create("admin/categories/%s".formatted(result.getId()))).body(result);
    }
    @PutMapping("{id}")
    ResponseEntity<AdminCategory> updateCategory(@PathVariable Long id,@RequestBody @Valid AdminCategoryDto adminCategoryDto){
        AdminCategory adminCategory = adminCategoryMapper.toAdminCategory(id, adminCategoryDto);
        AdminCategory result = adminCategoryFacade.updateCategory(adminCategory);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        adminCategoryFacade.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
