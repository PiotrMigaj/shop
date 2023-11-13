package pl.migibud.shop.product.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.product.domain.vo.ProductId;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@ToString
public class Product {
    
    private ProductId productId;
    private String name;
    private Long categoryId;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
    private List<Review> reviews;
}
