package pl.migibud.shop.admin.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.migibud.shop.admin.api.AdminProduct;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("admin/products")
@RequiredArgsConstructor
class AdminProductController {

    private static final Long EMPTY_ID = null;
    private final AdminProductFacade adminProductFacade;
    private final AdminProductMapper adminProductMapper;
    @GetMapping
    Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductFacade.getProducts(pageable);
    }
    @GetMapping("{id}")
    AdminProduct getProduct(@PathVariable Long id){
        return adminProductFacade.getProduct(id);
    }
    @PostMapping
    ResponseEntity<AdminProduct> createProduct(@Valid @RequestBody AdminProductDto adminProductDto){
        AdminProduct adminProduct = adminProductMapper.toAdminProduct(EMPTY_ID,adminProductDto);
        AdminProduct result = adminProductFacade.createProduct(adminProduct);
        return ResponseEntity.created(URI.create("admin/products/%s".formatted(result.getId()))).body(result);
    }
    @PutMapping("{id}")
    ResponseEntity<AdminProduct> updateProduct(@PathVariable Long id,@Valid @RequestBody AdminProductDto adminProductDto){
        AdminProduct adminProduct = adminProductMapper.toAdminProduct(id,adminProductDto);
        AdminProduct result = adminProductFacade.updateProduct(adminProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
}
