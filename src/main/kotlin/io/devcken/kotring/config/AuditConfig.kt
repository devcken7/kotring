package io.devcken.kotring.config

import io.devcken.kotring.auth.Account
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import java.util.*

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class AuditConfig {
    @Bean
    fun auditorAware(): SecurityAuditorAware {
        return SecurityAuditorAware()
    }
}

class SecurityAuditorAware: AuditorAware<Account> {
    override fun getCurrentAuditor(): Optional<Account> {
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication.isAuthenticated) {
            return Optional.of(authentication.principal as Account)
        }

        return Optional.empty()
    }
}