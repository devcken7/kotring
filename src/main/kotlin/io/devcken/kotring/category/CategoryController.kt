package io.devcken.kotring.category

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("categories")
class CategoryController(val categoryService: CategoryService) {
    @GetMapping
    fun categories(): ResponseEntity<MutableList<Category>> {
        return ok(categoryService.categories())
    }

    @PostMapping
    fun save(@RequestBody category: Category): ResponseEntity<Category> {
        return ok(categoryService.save(category))
    }
}
