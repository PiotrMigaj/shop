package pl.migibud.shop.basket.application.port.primary.querycart;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SummaryQueryModel(BigDecimal grossValue) {
}
