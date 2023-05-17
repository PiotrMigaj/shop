package pl.migibud.shop.admin.product.internal;

import com.github.slugify.Slugify;
import org.springframework.stereotype.Component;
import pl.migibud.shop.admin.product.api.AdminProduct;

@Component
class AdminProductMapper {
    AdminProduct toAdminProduct(Long id, AdminProductDto adminProductDto){
        return AdminProduct.builder()
                .id(id)
                .name(adminProductDto.name())
                .description(adminProductDto.description())
                .fullDescription(adminProductDto.fullDescription())
                .category(adminProductDto.category())
                .price(adminProductDto.price())
                .currency(adminProductDto.currency())
                .image(adminProductDto.image())
                .slug(slugifySlug(adminProductDto.slug()))
                .build();
    }
    AdminProductDto toAdminProductDto(AdminProduct adminProduct){
        return AdminProductDto.builder()
                .name(adminProduct.getName())
                .description(adminProduct.getDescription())
                .fullDescription(adminProduct.getFullDescription())
                .category(adminProduct.getCategory())
                .price(adminProduct.getPrice())
                .currency(adminProduct.getCurrency())
                .build();
    }
    private String slugifySlug(String slug){
        Slugify slg = Slugify.builder().customReplacement("_","-").build();
        return slg.slugify(slug);
    }
}
