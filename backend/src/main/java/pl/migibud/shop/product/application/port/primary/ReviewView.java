package pl.migibud.shop.product.application.port.primary;

import pl.migibud.shop.product.domain.vo.ReviewId;

public interface ReviewView {

    ReviewId getReviewId();
    String getAuthorName();
    String getContent();
    boolean getModerated();

}
