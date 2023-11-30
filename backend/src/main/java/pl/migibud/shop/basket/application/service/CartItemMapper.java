package pl.migibud.shop.basket.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.basket.application.port.primary.updatecart.model.UpdateCartItemCommand;
import pl.migibud.shop.basket.domain.model.CartItem;
import pl.migibud.shop.basket.domain.vo.CartItemId;

import java.util.List;

@Mapper
interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);
    
    List<CartItem> map(List<UpdateCartItemCommand> updateCartItemCommands);
    
    default CartItem map(UpdateCartItemCommand updateCartItemCommand){
        return CartItem.builder()
            .cartItemId(CartItemId.builder().id(updateCartItemCommand.cartItemId()).build())
            .quantity(updateCartItemCommand.quantity())
            .build();
    }


}

