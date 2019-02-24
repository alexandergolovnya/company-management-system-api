package com.universityspa.dto.auth;

import com.universityspa.entity.auth.Token;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO-class for entity Token
 */

@Data
@AllArgsConstructor
public class TokenDto {

    private String token;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getToken());
    }
}
