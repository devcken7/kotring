package io.devcken.kotring.category

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.devcken.kotring.spek.createContext
//import io.devcken.kotring.spek.InjectionFactory
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
//@CreateWith(InjectionFactory::class)
//class CategoryControllerSpek(val objectMapper: ObjectMapper): Spek({
//    describe("spring test") {
//        it("di") {
//            val category = objectMapper.readValue<Category>("{\"id\": 0, \"name\": \"category1\"}".byteInputStream())
//            expectThat(category.name).isEqualTo("category1")
//        }
//    }
//})
class CategoryControllerSpek: Spek({
    val context = createContext(CategoryControllerSpek::class)
    val objectMapper = context.inject<ObjectMapper>()

    describe("spring test") {
        it("di") {
            val category = objectMapper.readValue<Category>("{\"id\": 0, \"name\": \"category1\"}".byteInputStream())
            expectThat(category.name).isEqualTo("category1")
        }
    }
})