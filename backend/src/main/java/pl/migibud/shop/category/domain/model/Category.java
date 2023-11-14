package pl.migibud.shop.category.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.category.domain.vo.CategoryId;

import java.util.List;

@Getter
@Builder
@ToString
public class Category {

    private CategoryId categoryId;
    private String name;
    private String description;
    private String slug;
    private List<Product> products;
}
