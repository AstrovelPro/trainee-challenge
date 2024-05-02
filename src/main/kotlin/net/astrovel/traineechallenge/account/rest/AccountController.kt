package net.astrovel.traineechallenge.account.rest

import net.astrovel.traineechallenge.account.core.AccountService
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/accounts")
class AccountController(private val accountService: AccountService) {

    @PostMapping("/")
    fun create(@RequestBody account: AccountDTO) = ResponseEntity.ok(accountService.create(account))

    @GetMapping("/")
    fun all() = ResponseEntity.ok(accountService.all)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<*> {
        val account = accountService.get(id)
        if (account.isEmpty) return ResponseEntity.notFound().build<Any>()
        return ResponseEntity.ok(account.get())
    }

    @PutMapping("/")
    fun update(@RequestBody account: Account): ResponseEntity<Account> {
        return ResponseEntity.ok(accountService.update(account))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*> {
        accountService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
