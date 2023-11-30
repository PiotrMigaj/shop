package pl.migibud.shop.basket.adapter.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("basket.CartRepository")
interface CartRepository extends JpaRepository<CartEntity,Long> {
    List<CartEntity> findByCreatedLessThan(LocalDateTime localDateTime);
    
    @Query("delete from cart.CartEntity c where c.id in (:ids)")
    @Modifying
    void deleteAllByIdIn(List<Long> ids);
}
