package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.Article;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.Article}
 */
public record ArticleDto(
        Long id,
        UserAccountDto userAccountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime created_At,
        String created_By,
        LocalDateTime modified_At,
        String modified_By
) {
    public static ArticleDto of(Long id, UserAccountDto userAccountDto, String title, String content, String hashtag, LocalDateTime created_At, String created_By, LocalDateTime modified_At, String modified_By) {
        return new ArticleDto(id, userAccountDto, title, content, hashtag, created_At, created_By, modified_At, modified_By);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreated_At(),
                entity.getCreated_By(),
                entity.getModified_At(),
                entity.getModified_By()
        );
    }

    public Article toEntity() {
        return Article.of(
                userAccountDto.toEntity(),
                title,
                content,
                hashtag
        );
    }
}