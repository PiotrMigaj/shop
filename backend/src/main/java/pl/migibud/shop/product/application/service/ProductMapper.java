package pl.migibud.shop.product.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.product.application.port.primary.ProductWithReviewQueryModel;
import pl.migibud.shop.product.domain.model.Product;

@Mapper(uses = ReviewMapper.class)
interface ProductMapper {
    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    
    @Mapping(target = "id",source = "productId.id")
    @Mapping(target = "categoryId",source = "categoryId.id")
    ProductWithReviewQueryModel map(Product product);
}
