package io.devcken.kotring.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class JpaConfig(
    @PersistenceContext
    private val entityManager: EntityManager
) {
    @Bean
    fun queryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}