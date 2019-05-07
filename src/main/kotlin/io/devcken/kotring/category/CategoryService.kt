package io.devcken.kotring.category

import io.devcken.kotring.logger.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {
    private val logger by logger()

    @Value("\${custom.config.example}")
    private val customConfigExample: String = "default value"

    fun categories(): MutableList<Category> {
        logger.debug(customConfigExample)
        return categoryRepository.findAll()
    }

    fun category(id: Int): Optional<Category> = categoryRepository.findById(id)

    @Transactional
    fun save(category: Category): Category = categoryRepository.save(category)

    @Transactional
    fun delete(id: Int) = categoryRepository.deleteById(id)
}