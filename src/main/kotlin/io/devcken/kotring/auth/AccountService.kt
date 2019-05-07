package io.devcken.kotring.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AccountService(
    val accountRepository: AccountRepository,
    val authorityService: AuthorityService
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return accountRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("")
    }

    fun saveUser(account: Account): Account {
        account.authorities.addAll(authorityService.authorities(Role.USER))

        return accountRepository.save(account)
    }
}