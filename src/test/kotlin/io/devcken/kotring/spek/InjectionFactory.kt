package io.devcken.kotring.spek

import com.fasterxml.jackson.databind.ObjectMapper
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.InstanceFactory
import org.springframework.test.context.TestContextManager
import kotlin.reflect.KClass

class InjectionFactory: InstanceFactory {
    override fun <T : Spek> create(spek: KClass<T>): T {
        val context = TestContextManager(spek.java).testContext.applicationContext

        val objectMapper = context.getBean(ObjectMapper::class.java)

        return spek.constructors.first().call(objectMapper)
    }
}