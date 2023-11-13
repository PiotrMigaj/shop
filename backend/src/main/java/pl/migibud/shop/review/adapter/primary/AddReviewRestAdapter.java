package pl.migibud.shop.review.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.review.application.port.primary.AddReviewCommand;
import pl.migibud.shop.review.application.port.primary.AddReviewUseCase;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
class AddReviewRestAdapter {

    private final AddReviewUseCase addReviewUseCase;
    
    @PostMapping("api/v1/reviews")
    ResponseEntity<Map<String,Long>> addReview(@RequestBody @Valid CreateReviewRequestBody createReviewRequestBody){

        AddReviewCommand addReviewCommand = AddReviewCommand
            .builder()
            .authorName(cleanContent(createReviewRequestBody.authorName()))
            .content(cleanContent(createReviewRequestBody.content()))
            .productId(createReviewRequestBody.productId())
            .build();
        Long reviewId = addReviewUseCase.addReview(addReviewCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("reviewId",reviewId));
    }

    record CreateReviewRequestBody(
        @Length(min = 2,max = 60) String authorName,
        @Length(min = 2,max = 600) String content,
        Long productId){
    }

    private String cleanContent(String text){
        return Jsoup.clean(text, Safelist.none());
    }
    
}
