package pl.migibud.shop.admin.api;

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
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private AdminProductCurrency currency;

    @Builder
    public AdminProduct(Long id, String name, String category, String description, BigDecimal price, AdminProductCurrency currency) {
        super(id);
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    public enum AdminProductCurrency{
        PLN,USD
    }
}
