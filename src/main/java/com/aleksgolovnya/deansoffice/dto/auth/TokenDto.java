package com.aleksgolovnya.deansoffice.dto.auth;

import com.aleksgolovnya.deansoffice.entity.auth.Token;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO-class for entity Token
 */

@Data
@AllArgsConstructor
public class TokenDto {

    private String value;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getValue());
    }
}
