package ru.alexandergolovnya.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/05
 */
@Data
public class AccountDto {

    private int id;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(min = 8, max = 15)
    private String phone;

    @Size(min = 8, max = 60)
    private String password;

    private String firstName;
    private String middleName;
    private String lastName;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Set<AccountAuthorityDto> accountAuthorityDtos;
}
