package pl.migibud.shop.admin.internal;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import pl.migibud.shop.admin.api.AdminProduct.AdminProductCurrency;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
record AdminProductDto(
        @NotBlank @Length(min = 4) String name,
        @NotBlank @Length(min = 4) String category,
        @NotBlank @Length(min = 4) String description,
        @NotNull @Min(0) BigDecimal price,
        AdminProductCurrency currency,
        String image
) {
}
