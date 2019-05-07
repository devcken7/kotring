package io.devcken.kotring.item

import io.devcken.kotring.item.projection.ItemWithCategory

interface ItemRepositoryCustom {
    fun itemsWithCategory(): List<ItemWithCategory>
}