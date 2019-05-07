package io.devcken.kotring.auth

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table
data class Authority(
    @Id @GeneratedValue
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, updatable = false, columnDefinition = "SMALLINT")
    @Enumerated
    val role: Role
) : GrantedAuthority {

    override fun getAuthority(): String = name
}