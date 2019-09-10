package ru.alexandergolovnya.domain.dto;

import lombok.Data;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/09
 */
@Data
public class OAuthClient {

    private int id;
    private String clientId;
    private String clientSecret;
    private String authorizedGrantTypes;
    private String scopes;
    private int accessTokenValidity;
    private int refreshTokenValidity;
    private String authorities;
    private String resourceIds;
    private String redirectUris;
    private boolean autoApprove;
    private boolean secretRequired;
    private boolean scoped;
}
