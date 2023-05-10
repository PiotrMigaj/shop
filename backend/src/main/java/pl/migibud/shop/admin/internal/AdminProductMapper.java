package pl.migibud.shop.admin.internal;

import org.springframework.stereotype.Component;
import pl.migibud.shop.admin.api.AdminProduct;

@Component
class AdminProductMapper {
    AdminProduct toAdminProduct(Long id, AdminProductDto adminProductDto){
        return AdminProduct.builder()
                .id(id)
                .name(adminProductDto.name())
                .description(adminProductDto.description())
                .category(adminProductDto.category())
                .price(adminProductDto.price())
                .currency(adminProductDto.currency())
                .image(adminProductDto.image())
                .build();
    }
    AdminProductDto toAdminProductDto(AdminProduct adminProduct){
        return AdminProductDto.builder()
                .name(adminProduct.getName())
                .description(adminProduct.getDescription())
                .category(adminProduct.getCategory())
                .price(adminProduct.getPrice())
                .currency(adminProduct.getCurrency())
                .build();
    }
}
