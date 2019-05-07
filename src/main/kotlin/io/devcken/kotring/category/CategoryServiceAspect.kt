package io.devcken.kotring.category

import io.devcken.kotring.logger.logger
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class CategoryServiceAspect {
    private val logger by logger()

    @Before("execution(* io.devcken.kotring.category.CategoryService.*(..))")
    fun before(joinPoint: JoinPoint) {
        logger.debug("Yo!!")
    }
}