package pl.migibud.shop.basket.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import pl.migibud.shop.basket.domain.vo.CartId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@ToString
public class Cart {
    
    private final CartId cartId;
    private final LocalDateTime created;
    private final List<CartItem> items = new ArrayList<>();
    
    public static Cart createEmpty(){
        return Cart
            .builder()
            .created(LocalDateTime.now())
            .build();
    }

    public void addProduct(Product product, int quantity) {
        if (CollectionUtils.isEmpty(items)) {
            items.add(CartItem.createNew(quantity, product));
            return;
        }
        items
            .stream()
            .filter(cartItem -> cartItem
                .getProduct()
                .getProductId()
                .equals(product.getProductId()))
            .findFirst().ifPresentOrElse(cartItem -> cartItem.increaseQuantityOfProduct(quantity),()->
                items.add(CartItem.createNew(quantity,product))
            );
    }
    
    public BigDecimal calculateTotalValueOfCart(){
        return items.stream()
            .map(CartItem::calculateTotalValueOfProducts)
            .reduce(new BigDecimal("0.00"), BigDecimal::add);
    }
    
    public void addCartItems(List<CartItem> cartItems){
        items.addAll(cartItems);
    }
    
    public void updateCart(List<CartItem> cartItems){
        cartItems.forEach(
            cartItemUpdate -> items.forEach(
                item->{
                    if (item.getCartItemId().equals(cartItemUpdate.getCartItemId())){
                        item.setQuantity(cartItemUpdate.getQuantity());
                    }
                }
            )
        );
    }
    
}
