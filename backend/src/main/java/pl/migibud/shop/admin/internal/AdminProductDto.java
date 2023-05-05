package pl.migibud.shop.admin.internal;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
record AdminProductDto(
        String name,
        String category,
        String description,
        BigDecimal price,
        String currency
) {
}
