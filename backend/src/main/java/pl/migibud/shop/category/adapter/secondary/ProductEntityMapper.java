package pl.migibud.shop.category.adapter.secondary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.migibud.shop.category.domain.model.Product;
import pl.migibud.shop.category.domain.vo.CategoryId;
import pl.migibud.shop.category.domain.vo.ProductId;

import java.util.List;

@Mapper
interface ProductEntityMapper {
    
    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    default Page<Product> map(Page<ProductEntity> productEntities, Pageable pageable){
        return new PageImpl<>(map(productEntities.getContent()),pageable,productEntities.getTotalElements());
    }

    private Product map(ProductEntity productEntity) {
        return Product
            .builder()
            .productId(ProductId
                .builder()
                .id(productEntity.getId())
                .build())
            .name(productEntity.getName())
            .categoryId(CategoryId
                .builder()
                .id(productEntity.getCategoryId())
                .build())
            .description(productEntity.getDescription())
            .fullDescription(productEntity.getFullDescription())
            .price(productEntity.getPrice())
            .currency(productEntity.getCurrency())
            .image(productEntity.getImage())
            .slug(productEntity.getSlug())
            .build();
    }
    
    private List<Product> map(List<ProductEntity> productEntities){
        return productEntities.stream()
            .map(this::map)
            .toList();
    }

}
