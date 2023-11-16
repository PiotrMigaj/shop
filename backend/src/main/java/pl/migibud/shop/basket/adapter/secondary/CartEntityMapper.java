package pl.migibud.shop.basket.adapter.secondary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.model.CartItem;
import pl.migibud.shop.basket.domain.model.Product;
import pl.migibud.shop.basket.domain.vo.CartId;
import pl.migibud.shop.basket.domain.vo.CartItemId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
interface CartEntityMapper {

    CartEntityMapper INSTANCE = Mappers.getMapper(CartEntityMapper.class);

    default CartEntity mapToEntityWithoutCartItems(Cart cart) {
        return CartEntity
            .builder()
            .id(cart.getCartId() == null ?
                null :
                cart
                    .getCartId()
                    .id())
            .created(cart.getCreated())
            .build();
    }

    private ProductEntity mapToEntity(Product product) {
        return ProductEntity
            .builder()
            .id(product
                .getProductId()
                .id())
            .build();
    }

    default CartItemEntity mapToEntity(CartItem cartItem) {
        return CartItemEntity
            .builder()
            .id(cartItem
                .getCartItemId() == null ?
                null :
                cartItem
                    .getCartItemId()
                    .id())
            .quantity(cartItem.getQuantity())
            .product(mapToEntity(cartItem.getProduct()))
            .build();
    }

    default Cart map(CartEntity cartEntity) {
        Cart cart = Cart
            .builder()
            .cartId(CartId
                .builder()
                .id(cartEntity.getId())
                .build())
            .created(cartEntity.getCreated())
            .build();
        cart.addCartItems(map(cartEntity.getItems()));
        return cart;
    }

    default CartItem map(CartItemEntity cartItemEntity) {
        return CartItem
            .builder()
            .cartItemId(CartItemId
                .builder()
                .id(cartItemEntity.getId())
                .build())
            .quantity(cartItemEntity.getQuantity())
            .product(map(cartItemEntity.getProduct()))
            .build();
    }

    default List<CartItem> map(List<CartItemEntity> cartItemEntities) {
        return cartItemEntities
            .stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    default Product map(ProductEntity productEntity) {
        return Product
            .builder()
            .productId(ProductId
                .builder()
                .id(productEntity.getId())
                .build())
            .build();
    }

}
