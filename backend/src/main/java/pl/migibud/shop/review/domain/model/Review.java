package pl.migibud.shop.review.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.review.domain.vo.ProductId;
import pl.migibud.shop.review.domain.vo.ReviewId;

@Getter
@ToString
@Builder
public class Review {
    
    private ReviewId reviewId;
    private ProductId productId;
    private String authorName;
    private String content;
    private boolean moderated;
}
