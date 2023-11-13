package pl.migibud.shop.product.application.port.primary;

public interface ReviewView {

    Long getId();
    String getAuthorName();
    String getContent();
    boolean getModerated();

}
