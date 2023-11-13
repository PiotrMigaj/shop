package pl.migibud.shop.review.application.service;

import org.junit.jupiter.api.Test;
import pl.migibud.shop.review.application.port.primary.AddReviewCommand;
import pl.migibud.shop.review.domain.model.Review;

import static java.util.UUID.randomUUID;

class ReviewMapperTest {

    
    @Test
    void shouldMapToReview(){
        //given
        AddReviewCommand command = AddReviewCommand
            .builder()
            .authorName(randomUUID()
                .toString())
            .content(randomUUID()
                .toString())
            .productId(1L)
            .build();
        //when
        Review review = ReviewMapper.INSTANCE.map(command);

        //then
        System.out.println(review);
    }
}