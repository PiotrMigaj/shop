package pl.migibud.shop.basket.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import pl.migibud.shop.basket.domain.vo.CartId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@ToString
public class Cart {
    
    private CartId cartId;
    private LocalDateTime created;
    private final List<CartItem> items = new ArrayList<>();
    
    public static Cart createEmpty(){
        return Cart
            .builder()
            .created(LocalDateTime.now())
            .build();
    }

    public void addProduct(ProductId productId, int quantity) {
        if (CollectionUtils.isEmpty(items)) {
            items.add(CartItem.createNew(quantity, productId));
            return;
        }
        items
            .stream()
            .filter(cartItem -> cartItem
                .getProductId()
                .equals(productId))
            .findFirst().ifPresentOrElse(cartItem -> cartItem.increaseQuantityOfProduct(quantity),()->
                items.add(CartItem.createNew(quantity,productId))
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
    
}
