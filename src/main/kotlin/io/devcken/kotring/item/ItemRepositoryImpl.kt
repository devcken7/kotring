package io.devcken.kotring.item

import com.querydsl.core.types.Projections.bean
import com.querydsl.jpa.impl.JPAQueryFactory
import io.devcken.kotring.category.QCategory.category
import io.devcken.kotring.item.QItem.item
import io.devcken.kotring.item.projection.ItemWithCategory

class ItemRepositoryImpl(private val queryFactory: JPAQueryFactory) {
    fun itemsWithCategory(): List<ItemWithCategory> {
        return queryFactory
            .select(
                bean(ItemWithCategory::class.java,
                    item.id,
                    item.name,
                    category.name.`as`("categoryName")
                )
            )
            .from(item)
            .innerJoin(category)
            .fetchJoin()
            .on(item.category.id.eq(category.id))
            .fetch()
    }
}