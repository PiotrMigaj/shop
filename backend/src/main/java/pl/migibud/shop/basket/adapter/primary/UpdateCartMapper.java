package pl.migibud.shop.basket.adapter.primary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.basket.adapter.primary.UpdateCartRestAdapter.UpdateCartItemRequest;
import pl.migibud.shop.basket.adapter.primary.UpdateCartRestAdapter.UpdateCartRequest;
import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartCommand;
import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartItemCommand;
import pl.migibud.shop.basket.domain.vo.CartId;

import java.util.List;

@Mapper
interface UpdateCartMapper {

    UpdateCartMapper INSTANCE = Mappers.getMapper(UpdateCartMapper.class);

    default UpdateCartCommand map(Long cartId, UpdateCartRequest updateCartRequest) {
        return UpdateCartCommand
            .builder()
            .cartId(CartId
                .builder()
                .id(cartId)
                .build()
                .id())
            .updateCartItemCommands(map(updateCartRequest.updateCartItemRequests()))
            .build();
    }

    private UpdateCartItemCommand map(UpdateCartItemRequest updateCartItemRequest) {
        return UpdateCartItemCommand
            .builder()
            .cartItemId(updateCartItemRequest.cartItemId())
            .quantity(updateCartItemRequest.quantity())
            .build();
    }
    
    private List<UpdateCartItemCommand> map(List<UpdateCartItemRequest> updateCartItemRequests){
        return updateCartItemRequests.stream()
            .map(this::map)
            .toList();
    }
}
