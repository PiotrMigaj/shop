package pl.migibud.shop.category.adapter.secondary;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category.CategoryEntity")
@Table(name = "CATEGORY")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String slug;
    @OneToMany
    @JoinColumn(name = "categoryId")
    private List<ProductEntity> products;
}
