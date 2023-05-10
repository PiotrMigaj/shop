package pl.migibud.shop.admin.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.migibud.shop.admin.api.AdminProduct;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@RestController
//@RequestMapping("admin/products")
@RequiredArgsConstructor
class AdminProductController {

    private static final Long EMPTY_ID = null;
    private final AdminProductFacade adminProductFacade;
    private final AdminProductImageFacade adminProductImageFacade;
    private final AdminProductMapper adminProductMapper;
    @GetMapping("admin/products")
    Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductFacade.getProducts(pageable);
    }
    @GetMapping("admin/products/{id}")
    AdminProduct getProduct(@PathVariable Long id){
        return adminProductFacade.getProduct(id);
    }
    @PostMapping("admin/products")
    ResponseEntity<AdminProduct> createProduct(@Valid @RequestBody AdminProductDto adminProductDto){
        AdminProduct adminProduct = adminProductMapper.toAdminProduct(EMPTY_ID,adminProductDto);
        AdminProduct result = adminProductFacade.createProduct(adminProduct);
        return ResponseEntity.created(URI.create("admin/products/%s".formatted(result.getId()))).body(result);
    }
    @PutMapping("admin/products/{id}")
    ResponseEntity<AdminProduct> updateProduct(@PathVariable Long id,@Valid @RequestBody AdminProductDto adminProductDto){
        AdminProduct adminProduct = adminProductMapper.toAdminProduct(id,adminProductDto);
        AdminProduct result = adminProductFacade.updateProduct(adminProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
    @DeleteMapping("admin/products/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        adminProductFacade.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PostMapping("admin/products/upload-image")
    UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile){
        try(InputStream inputStream = multipartFile.getInputStream()) {
            String savedFileName = adminProductImageFacade.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFileName);
        }catch (IOException e){
            throw new IllegalStateException("Something wrong while uploading file...",e);
        }
    }
    @GetMapping("data/productImage/{filename}")
    ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource file = adminProductImageFacade.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(file);
    }
}
