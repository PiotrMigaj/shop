package pl.migibud.shop.basket.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.basket.application.port.primary.countitems.CountItemsInCartUseCase;
import pl.migibud.shop.basket.application.port.primary.countitems.model.CountItemsInCartQueryModel;
import pl.migibud.shop.basket.application.port.secondary.CountItemsInCartPort;
import pl.migibud.shop.basket.domain.vo.CartId;

@Service
@RequiredArgsConstructor
class CountItemsInCartService implements CountItemsInCartUseCase {

    private final CountItemsInCartPort countItemsInCartPort;

    @Override
    public Long count(CountItemsInCartQueryModel queryModel) {
        return countItemsInCartPort.count(CartId
            .builder()
            .id(queryModel.cartId())
            .build());
    }
}
