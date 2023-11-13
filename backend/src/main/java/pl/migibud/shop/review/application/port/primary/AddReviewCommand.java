package pl.migibud.shop.review.application.port.primary;

import lombok.Builder;

@Builder
public record AddReviewCommand(String authorName,String content,Long productId) {
}
