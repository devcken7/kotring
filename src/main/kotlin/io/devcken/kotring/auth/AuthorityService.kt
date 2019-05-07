package io.devcken.kotring.auth

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AuthorityService(
    val authorityRepository: AuthorityRepository
) {

    @Cacheable
    fun authorities(role: Role): List<Authority> = authorityRepository.findByRole(role)

    @Transactional
    fun save(authority: Authority): Authority = authorityRepository.save(authority)
}