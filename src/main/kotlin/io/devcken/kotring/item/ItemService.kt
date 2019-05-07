package io.devcken.kotring.item

import io.devcken.kotring.item.projection.ItemWithCategory
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {
    fun itemsWithCategory(): List<ItemWithCategory> {
        return itemRepository.itemsWithCategory()
    }
}