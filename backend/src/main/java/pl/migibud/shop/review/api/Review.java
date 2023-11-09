package pl.migibud.shop.review.api;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.migibud.shop.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Review extends BaseEntity {
    
    private Long productId;
    private String authorName;
    private String content;
    private boolean moderated;
}

