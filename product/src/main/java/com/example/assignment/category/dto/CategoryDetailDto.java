package com.example.assignment.category.dto;

import com.example.assignment.category.domain.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDetailDto {
    public record Request(@NotNull Long categoryId) {}
    @Builder
    public record Response(Long categoryId, Long parentId, String name, String parentName, LocalDateTime createdDateTime, LocalDateTime modifyDateTime){
        public static Response fromEntity(Category category) {
            Category parent = category.getParent();
            Long parentId = ObjectUtils.isNotEmpty(parent) ? parent.getCategoryId() : null;
            String parentName = ObjectUtils.isNotEmpty(parent) ? parent.getName() : null;

            return Response.builder()
                    .categoryId(category.getCategoryId())
                    .name(category.getName())
                    .parentId(parentId)
                    .parentName(parentName)
                    .createdDateTime(category.getCreatedDatetime())
                    .modifyDateTime(category.getModifyDatetime())
                    .build();
        }
    }
}
