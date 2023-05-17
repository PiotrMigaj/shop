package pl.migibud.shop.admin.category.internal;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Builder
record AdminCategoryDto(
        @NotBlank @Length(min=4) String name,
        String description,
        @NotBlank @Length(min=4) String slug
) {
}
