package pl.migibud.shop.product.api;


import lombok.*;
import pl.migibud.shop.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Product extends BaseEntity {

    private String name;
    private String category;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
}
