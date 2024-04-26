package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.ArticleComment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsDto(
        Long id,
        UserAccountDto userAccountDto,
        Set<ArticleCommentDto> articleCommentDtos,
        String title,
        String content,
        String hashtag,
        LocalDateTime created_At,
        String created_By,
        LocalDateTime modified_At,
        String modified_By
) {
    public static ArticleWithCommentsDto of(Long id, UserAccountDto userAccountDto, Set<ArticleCommentDto> articleCommentDtos, String title, String content, String hashtag, LocalDateTime created_At, String created_By, LocalDateTime modified_At, String modified_By){
        return new ArticleWithCommentsDto(id, userAccountDto, articleCommentDtos, title, content, hashtag, created_At, created_By, modified_At, modified_By);
    }

    public static ArticleWithCommentsDto from(Article entity){
        return new ArticleWithCommentsDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getArticleComments().stream()
                        .map(ArticleCommentDto::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreated_At(),
                entity.getCreated_By(),
                entity.getModified_At(),
                entity.getModified_By()
        );
    }
}