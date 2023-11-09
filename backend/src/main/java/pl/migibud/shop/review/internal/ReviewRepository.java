package pl.migibud.shop.review.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.migibud.shop.review.api.Review;
import pl.migibud.shop.review.api.ReviewQueryRepository;

interface ReviewRepository extends ReviewQueryRepository, JpaRepository<Review,Long> {
}
