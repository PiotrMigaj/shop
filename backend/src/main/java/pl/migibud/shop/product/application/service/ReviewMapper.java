package pl.migibud.shop.product.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.product.application.port.primary.ReviewQueryModel;
import pl.migibud.shop.product.domain.model.Review;

@Mapper
interface ReviewMapper {
    
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    
    @Mapping(target = "id",source = "reviewId.id")
    ReviewQueryModel map(Review review);
}
