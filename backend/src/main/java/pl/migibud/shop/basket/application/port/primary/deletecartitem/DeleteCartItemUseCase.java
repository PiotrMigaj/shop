package pl.migibud.shop.basket.application.port.primary.deletecartitem;

import pl.migibud.shop.basket.application.port.primary.deletecartitem.model.DeleteCartItemCommand;

public interface DeleteCartItemUseCase {
    void delete(DeleteCartItemCommand command);
}
