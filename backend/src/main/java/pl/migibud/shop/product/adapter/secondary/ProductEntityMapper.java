package pl.migibud.shop.product.adapter.secondary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.product.domain.model.Product;
import pl.migibud.shop.product.domain.model.Review;
import pl.migibud.shop.product.domain.vo.CategoryId;
import pl.migibud.shop.product.domain.vo.ProductId;
import pl.migibud.shop.product.domain.vo.ReviewId;

import java.util.List;

@Mapper
interface ProductEntityMapper {

    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    default Product map(ProductEntity productEntity, List<ReviewEntity> reviewEntities) {
        return Product.builder()
            .productId(ProductId.builder().id(productEntity.getId()).build())
            .name(productEntity.getName())
            .categoryId(CategoryId.builder().id(productEntity.getCategoryId()).build())
            .description(productEntity.getDescription())
            .fullDescription(productEntity.getFullDescription())
            .price(productEntity.getPrice())
            .currency(productEntity.getCurrency())
            .image(productEntity.getImage())
            .slug(productEntity.getSlug())
            .reviews(map(reviewEntities))
                      .build();
    }

    private Review map(ReviewEntity reviewEntity) {
        return Review
            .builder()
            .reviewId(ReviewId
                .builder()
                .id(reviewEntity.getId())
                .build())
            .authorName(reviewEntity.getAuthorName())
            .content(reviewEntity.getContent())
            .moderated(reviewEntity.isModerated())
            .build();
    }
    
    private List<Review> map(List<ReviewEntity> reviewEntities){
        return reviewEntities.stream()
            .map(this::map)
            .toList();
    }

}
