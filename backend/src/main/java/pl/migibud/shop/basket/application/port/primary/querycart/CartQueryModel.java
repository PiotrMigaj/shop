package pl.migibud.shop.basket.application.port.primary.querycart;

import lombok.Builder;

import java.util.List;

@Builder
public record CartQueryModel(
    Long cartId,
    List<CartItemQueryModel> cartItemQueryModels,
    SummaryQueryModel summaryQueryModel
) {
}
