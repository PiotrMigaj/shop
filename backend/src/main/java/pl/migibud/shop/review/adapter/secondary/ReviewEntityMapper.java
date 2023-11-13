package pl.migibud.shop.review.adapter.secondary;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.review.domain.model.Review;

@Mapper
interface ReviewEntityMapper {

    ReviewEntityMapper INSTANCE = Mappers.getMapper(ReviewEntityMapper.class);
    
    @Mapping(target = "productId",source = "productId.id")
    ReviewEntity map(Review review);
    
    @Mapping(target = "reviewId.id",source = "id")
    @Mapping(target = "productId.id",source = "id")
    Review map(ReviewEntity reviewEntity);
}
