package io.devcken.kotring.item

import io.devcken.kotring.category.Category
import javax.persistence.*

@Entity
@Table
data class Item(
    @Id @GeneratedValue
    val id: Int,

    @Column(nullable = false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category
)