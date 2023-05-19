package pl.migibud.shop.admin.product.internal;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import pl.migibud.shop.admin.product.api.AdminProduct;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
record AdminProductDto(
        @NotBlank @Length(min = 4) String name,
        @NotNull Long categoryId,
        @NotBlank @Length(min = 4) String description,
        String fullDescription,
        @NotNull @Min(0) BigDecimal price,
        AdminProduct.AdminProductCurrency currency,
        String image,
        @NotBlank @Length(min = 4) String slug
) {
}
