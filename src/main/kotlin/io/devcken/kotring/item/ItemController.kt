package io.devcken.kotring.item

import io.devcken.kotring.item.projection.ItemWithCategory
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("items")
class ItemController(private val itemService: ItemService) {
    @GetMapping
    fun itemsWithCategory(): ResponseEntity<List<ItemWithCategory>> {
        return ok(itemService.itemsWithCategory())
    }
}