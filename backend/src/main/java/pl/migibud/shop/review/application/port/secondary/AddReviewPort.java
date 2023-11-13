package pl.migibud.shop.review.application.port.secondary;

import pl.migibud.shop.review.domain.model.Review;

@FunctionalInterface
public interface AddReviewPort {

    Review save(Review review);
}
