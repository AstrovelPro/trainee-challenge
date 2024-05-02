package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.data.AccountRepository
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.mapper.toDto
import net.astrovel.traineechallenge.account.mapper.toEntity
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

import org.springframework.stereotype.Component

@Component
class AccountService(private val accountRepository: AccountRepository) {

    fun create(account: AccountDTO) = accountRepository.save(account.toEntity())

    fun update(account: Account) = accountRepository.save(account)

    fun delete(id: Long) = accountRepository.deleteById(id)

    fun get(id: Long) = accountRepository.findById(id)

    val all: Page<AccountDTO>
        get() = accountRepository.findAll(PageRequest.of(0, 10)).map(Account::toDto)
}
