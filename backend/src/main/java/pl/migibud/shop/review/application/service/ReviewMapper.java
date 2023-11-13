package pl.migibud.shop.review.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.review.application.port.primary.AddReviewCommand;
import pl.migibud.shop.review.domain.model.Review;

@Mapper
interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    
    @Mapping(target = "reviewId",ignore = true)
    @Mapping(target = "productId.id",source = "productId")
    Review map(AddReviewCommand addReviewCommand);

}
