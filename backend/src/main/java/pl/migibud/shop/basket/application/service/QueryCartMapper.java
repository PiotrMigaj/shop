package pl.migibud.shop.basket.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.basket.application.port.primary.querycart.CartItemQueryModel;
import pl.migibud.shop.basket.application.port.primary.querycart.CartQueryModel;
import pl.migibud.shop.basket.application.port.primary.querycart.ProductQueryModel;
import pl.migibud.shop.basket.application.port.primary.querycart.SummaryQueryModel;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.model.CartItem;
import pl.migibud.shop.basket.domain.model.Product;

import java.util.List;

@Mapper
interface QueryCartMapper {

    QueryCartMapper INSTANCE = Mappers.getMapper(QueryCartMapper.class);

    default CartQueryModel map(Cart cart) {
        return CartQueryModel
            .builder()
            .cartId(cart
                .getCartId()
                .id())
            .cartItemQueryModels(map(cart.getItems()))
            .summaryQueryModel(SummaryQueryModel
                .builder()
                .grossValue(cart.calculateTotalValueOfCart())
                .build())
            .build();
    }
    
    private List<CartItemQueryModel> map(List<CartItem> cartItems){
        return cartItems.stream().map(this::map).toList();
    }

    private CartItemQueryModel map(CartItem cartItem) {
        return CartItemQueryModel
            .builder()
            .id(cartItem
                .getCartItemId()
                .id())
            .quantity(cartItem.getQuantity())
            .lineValue(cartItem.calculateTotalValueOfProducts())
            .productQueryModel(map(cartItem.getProduct()))
            .build();
    }

    private ProductQueryModel map(Product product) {
        return ProductQueryModel
            .builder()
            .id(product
                .getProductId()
                .id())
            .currency(product.getCurrency())
            .image(product.getImage())
            .name(product.getName())
            .price(product.getPrice())
            .slug(product.getSlug())
            .build();
    }
}
