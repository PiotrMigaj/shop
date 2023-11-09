package pl.migibud.shop.review.api;

import java.util.List;

@FunctionalInterface
public interface ReviewQueryRepository {

    List<Review> findAllByProductIdAndModerated(Long productId,boolean moderated);
}
