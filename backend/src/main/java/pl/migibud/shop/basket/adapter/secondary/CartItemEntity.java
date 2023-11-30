package pl.migibud.shop.basket.adapter.secondary;

import lombok.*;

import javax.persistence.*;

@Entity(name = "cart.CartItemEntity")
@Table(name = "CART_ITEM")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne(fetch = FetchType.LAZY)
    private ProductEntity product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    @Setter
    private CartEntity cart;
}
