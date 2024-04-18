package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.UserAccount;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.UserAccount}
 */
public record UserAccountDto(
        Long id,
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo,
        LocalDateTime created_At,
        String created_By,
        LocalDateTime modified_At,
        String modified_By
) {
    public static UserAccountDto of(Long id, String userId, String userPassword, String email, String nickname, String memo, LocalDateTime created_At, String created_By, LocalDateTime modified_At, String modified_By){
        return new UserAccountDto(id, userId, userPassword, email, nickname, memo, created_At, created_By, modified_At, modified_By);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreated_At(),
                entity.getCreated_By(),
                entity.getModified_At(),
                entity.getModified_By()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }
}