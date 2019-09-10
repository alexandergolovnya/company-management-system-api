package ru.alexandergolovnya.domain.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/05
 */
@Data
@Entity
public class AccountAuthorityDto {

    private int id;
    private String authorityName;
}
