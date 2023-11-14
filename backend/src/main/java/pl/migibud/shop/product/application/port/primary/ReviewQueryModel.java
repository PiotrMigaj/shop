package pl.migibud.shop.product.application.port.primary;

public record ReviewQueryModel(
    Long id,
    String authorName,
    String content
) {
}
