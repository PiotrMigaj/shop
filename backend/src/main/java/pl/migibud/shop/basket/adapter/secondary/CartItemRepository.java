package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("basket.CartItemRepository")
interface CartItemRepository extends JpaRepository<CartItemEntity,Long> {
    Long countByCartId(Long cartId);
    
    @Query("delete from cart.CartItemEntity ci where ci.cart.id in (:ids)")
    @Modifying
    void deleteAllByCartIdIn(List<Long> ids);
}
