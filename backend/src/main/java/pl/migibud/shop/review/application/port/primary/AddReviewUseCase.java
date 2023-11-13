package pl.migibud.shop.review.application.port.primary;

@FunctionalInterface
public interface AddReviewUseCase {

    Long addReview(AddReviewCommand addReviewCommand);
}
