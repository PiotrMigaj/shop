package pl.migibud.shop.product.application.port.primary;

import java.math.BigDecimal;
import java.util.List;

public interface ProductWithReviewView {

    Long getId();
    String getName();
    Long getCategoryId();
    String getDescription();
    String getFullDescription();
    BigDecimal getPrice();
    String getCurrency();
    String getImage();
    String getSlug();
    List<ReviewView> getReviews();
}

