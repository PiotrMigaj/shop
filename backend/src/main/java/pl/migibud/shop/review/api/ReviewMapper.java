package pl.migibud.shop.review.api;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewMapper {


    public ReviewDto map(Review review){
        return ReviewDto.builder()
            .id(review.getId())
            .productId(review.getProductId())
            .content(review.getContent())
            .authorName(review.getAuthorName())
            .moderate(review.isModerated())
            .build();
    }
    
    public List<ReviewDto> map(List<Review> reviews){
        return reviews.stream()
            .map(this::map)
            .toList();
    }

}
