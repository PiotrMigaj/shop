package pl.migibud.shop.category.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.category.domain.vo.CategoryId;
import pl.migibud.shop.category.domain.vo.ProductId;

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
