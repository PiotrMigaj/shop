package pl.migibud.shop.basket.application.port.primary.countitems;

import pl.migibud.shop.basket.application.port.primary.countitems.model.CountItemsInCartQueryModel;

public interface CountItemsInCartUseCase {
    Long count(CountItemsInCartQueryModel queryModel);
}
