package ru.alexandergolovnya.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexandergolovnya.domain.dto.AccountAuthorityDto;
import ru.alexandergolovnya.domain.entity.AccountAuthority;
import ru.alexandergolovnya.domain.repository.AccountAuthorityRepository;

import java.util.List;
import java.util.Optional;

import static ru.alexandergolovnya.utils.ModelMapperUtils.map;
import static ru.alexandergolovnya.utils.ModelMapperUtils.mapAll;

/**
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/10
 */
@Service
@RequiredArgsConstructor
public class AccountAuthorityServiceImpl implements AccountAuthorityService {

    private final AccountAuthorityRepository accountAuthorityRepository;

    @Override
    public AccountAuthorityDto createAccountAuthority(AccountAuthorityDto accountAuthorityDto) {
        checkAccountAuthorityNameForUniqueness(accountAuthorityDto);

        final AccountAuthority accountAuthority = map(accountAuthorityDto, AccountAuthority.class);
        accountAuthorityRepository.save(accountAuthority);

        return map(accountAuthority, AccountAuthorityDto.class);
    }

    @Override
    public AccountAuthorityDto editAccountAuthority(int id, AccountAuthorityDto accountAuthorityDto) {
        checkAccountAuthorityNameForUniqueness(accountAuthorityDto);

        final Optional<AccountAuthority> accountRoleToEdit = accountAuthorityRepository.findById(id);
        if (accountRoleToEdit.isPresent()) {
            final AccountAuthority accountAuthority = accountRoleToEdit.get();
            accountAuthority.setAuthorityName(accountAuthorityDto.getAuthorityName());
            accountAuthorityRepository.save(accountAuthority);
            return map(accountAuthority, AccountAuthorityDto.class);

        } else throw new IllegalArgumentException("Account authority with such id doesn't exists");
    }

    @Override
    public void deleteAAccountAuthority(int id) {
        if (accountAuthorityRepository.existsById(id)) {

            accountAuthorityRepository.deleteById(id);

        } else throw new IllegalArgumentException("Account authority with such id doesn't exists");
    }

    @Override
    public AccountAuthorityDto getAccountAuthority(int id) {
        final Optional<AccountAuthority> accountAuthority = accountAuthorityRepository.findById(id);
        if (accountAuthority.isPresent()) {
            return map(accountAuthority, AccountAuthorityDto.class);
        } else throw new IllegalArgumentException("Account authority with such id doesn't exists");
    }

    @Override
    public List<AccountAuthorityDto> getAllAccountAuthorities() {
        return mapAll(accountAuthorityRepository.findAll(), AccountAuthorityDto.class);
    }

    private void checkAccountAuthorityNameForUniqueness(AccountAuthorityDto accountAuthorityDto) {
        final Optional<AccountAuthority> accountAuthority =
                accountAuthorityRepository.findByAuthorityName(accountAuthorityDto.getAuthorityName());

        if (accountAuthority.isPresent()) {
            throw new IllegalArgumentException("Account authority with such name already exists.");
        }
    }
}