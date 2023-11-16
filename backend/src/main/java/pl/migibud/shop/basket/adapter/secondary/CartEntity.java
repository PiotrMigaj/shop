package pl.migibud.shop.basket.adapter.secondary;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cart.CartEntity")
@Table(name = "CART")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created;
    @OneToMany(mappedBy = "cart",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Fetch(FetchMode.JOIN)
    private List<CartItemEntity> items = new ArrayList<>();

    void addCartItemEntity(CartItemEntity cartItemEntity) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(cartItemEntity);
        cartItemEntity.setCart(this);
    }
}
