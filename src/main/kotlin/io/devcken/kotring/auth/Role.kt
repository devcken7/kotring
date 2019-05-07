package io.devcken.kotring.auth

import org.springframework.core.convert.converter.Converter

enum class Role(val value: Short) {
    ADMIN(0),
    USER(1);

    companion object {
        private val map = values().associateBy { it.value }
        fun fromInt(value: Short) = map[value]
    }
}

class RoleParameterConverter : Converter<String, Role> {
    override fun convert(source: String): Role? {
        return Role.fromInt(source.toShort())
    }
}