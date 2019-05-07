package io.devcken.kotring.auth

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("accounts")
class AccountController(val accountService: AccountService) {
    @PostMapping
    fun signup(@RequestBody account: Account): ResponseEntity<Account> {
        return ok(accountService.saveUser(account))
    }
}