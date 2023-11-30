package pl.migibud.shop.basket.application.port.primary.updatecart;

import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartCommand;
import pl.migibud.shop.basket.domain.vo.CartId;

public interface UpdateCartUseCase {
    CartId update(UpdateCartCommand updateCartCommand);
}
