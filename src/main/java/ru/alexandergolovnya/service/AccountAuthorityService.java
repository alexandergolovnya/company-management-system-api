package ru.alexandergolovnya.service;

import ru.alexandergolovnya.domain.dto.AccountAuthorityDto;

import java.util.List;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/10
 */
public interface AccountAuthorityService {

    AccountAuthorityDto createAccountAuthority(AccountAuthorityDto accountAuthorityDto);

    AccountAuthorityDto editAccountAuthority(int id, AccountAuthorityDto accountAuthorityDto);

    void deleteAAccountAuthority(int id);

    AccountAuthorityDto getAccountAuthority(int id);

    List<AccountAuthorityDto> getAllAccountAuthorities();
}
