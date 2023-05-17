package pl.migibud.shop.admin.product.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.migibud.shop.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminProduct extends BaseEntity {
    private String name;
    private String category;
    private String description;
    private String fullDescription;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private AdminProductCurrency currency;
    private String image;
    private String slug;

    @Builder
    public AdminProduct(Long id, String name, String category, String description,
                        final String fullDescription,
                        BigDecimal price, AdminProductCurrency currency, String image, String slug) {
        super(id);
        this.name = name;
        this.category = category;
        this.description = description;
        this.fullDescription = fullDescription;
        this.price = price;
        this.currency = currency;
        this.image = image;
        this.slug = slug;
    }

    public enum AdminProductCurrency{
        PLN,USD
    }
}
