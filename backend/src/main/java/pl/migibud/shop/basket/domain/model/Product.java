package pl.migibud.shop.basket.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.basket.domain.vo.CategoryId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class Product {

    private ProductId productId;
    private String name;
    private CategoryId categoryId;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
    
    
}
