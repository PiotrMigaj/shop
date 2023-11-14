package pl.migibud.shop.product.application.port.primary;

import java.math.BigDecimal;

public interface QueryProductsView {

    Long getId();
    String getName();
    Long getCategoryId();
    String getDescription();
    String getFullDescription();
    BigDecimal getPrice();
    String getCurrency();
    String getImage();
    String getSlug();
    
}
