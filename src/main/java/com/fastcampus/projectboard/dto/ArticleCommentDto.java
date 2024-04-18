package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.ArticleComment;

import java.time.LocalDateTime;
public record ArticleCommentDto(
        Long id,
        Long articleId,
        UserAccountDto userAccountDto,
        String content,
        LocalDateTime created_At,
        String created_By,
        LocalDateTime modified_At,
        String modified_By
) {
    public static ArticleCommentDto of(Long id, Long articleId, UserAccountDto userAccountDto, String content, LocalDateTime created_At, String created_By, LocalDateTime modified_At, String modified_By) {
        return new ArticleCommentDto(id, articleId, userAccountDto, content, created_At, created_By, modified_At, modified_By);
    }

    public static ArticleCommentDto from(ArticleComment entity){
        return new ArticleCommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getContent(),
                entity.getCreated_At(),
                entity.getCreated_By(),
                entity.getModified_At(),
                entity.getModified_By()
        );
    }

    public ArticleComment toEntity(Article entity) {
        return ArticleComment.of(
            entity,
            userAccountDto.toEntity(),
            content
        );
    }
}