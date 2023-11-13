package pl.migibud.shop.product.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.product.domain.vo.ReviewId;

@Getter
@ToString
@Builder
public class Review {
    
    private ReviewId reviewId;
    private String authorName;
    private String content;
    private boolean moderated;
}
