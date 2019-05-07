package io.devcken.kotring.category

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CategoryServiceSpek: Spek({
    val categoryRepository = mock<CategoryRepository> {
        on { findAll() } doReturn mutableListOf(Category("category1"))
    }

    val categoryService = CategoryService(categoryRepository)

    describe("test") {
        val categories = categoryService.categories()
        it("result") {
            expectThat(categories.size).isEqualTo(1)
        }
    }
})