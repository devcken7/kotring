package io.devcken.kotring.spek

import org.spekframework.spek2.dsl.Root
import org.spekframework.spek2.lifecycle.*
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestContext
import org.springframework.test.context.TestContextManager
import kotlin.reflect.KClass

class SpringContext internal constructor(testContextManager: TestContextManager,
                                         val root: Root): LifecycleListener {
    val testContext: TestContext by lazy { testContextManager.testContext }

    inline fun <reified T: Any> inject(): T {
        val injected by root.memoized {
            testContext.applicationContext.getBean(T::class.java)
        }

        return injected
    }

    override fun afterExecuteTest(test: TestScope) {
        testContext.markApplicationContextDirty(DirtiesContext.HierarchyMode.EXHAUSTIVE)
    }
}

fun Root.createContext(spek: KClass<*>): SpringContext {
    return SpringContext(TestContextManager(spek.java), this@createContext).apply {
        registerListener(this)
    }
}