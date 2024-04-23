package com.fastcampus.projectboard.dto.response;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.dto.ArticleDto;

import java.time.LocalDateTime;

public record ArticleResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime created_At,
        String email,
        String nickname
) {

    public static ArticleResponse of(Long id, String title, String content, String hashtag, LocalDateTime created_At, String email, String nickname) {
        return new ArticleResponse(id, title, content, hashtag, created_At, email, nickname);
    }

    public static ArticleResponse from(ArticleDto dto){
        String nickname = dto.userAccountDto().nickname();
        if(nickname == null || nickname.isBlank()){
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.created_At(),
                dto.userAccountDto().email(),
                nickname
        );
    }

}
