package ru.alexandergolovnya.service;

import ru.alexandergolovnya.domain.dto.AccountDto;

import java.util.List;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/10
 */
public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto editAccount(int id, AccountDto accountDto);

    void deleteAAccount(int id);

    AccountDto getAccount(int id);

    AccountDto getAccountByPhone(String phone);

    AccountDto getAccountByEmail(String email);

    List<AccountDto> getAllAccounts();
}
