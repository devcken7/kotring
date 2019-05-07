package io.devcken.kotring.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table
data class Account(
    @Id @GeneratedValue
    val id: Int = 0,

    @Column(nullable = false)
    @get:JvmName("getUsername_")
    val username: String,

    @Column(nullable = false)
    @get:JvmName("getPassword_")
    val password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "account_authority",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "authority_id", referencedColumnName = "id")]
    )
    @get:JvmName("getAuthorities_")
    val authorities: MutableCollection<Authority> = mutableListOf(),

    @Column(nullable = false, columnDefinition = "BIT(1) DEFAULT 1")
    val enabled: Boolean = true,

    @Column(nullable = false, columnDefinition = "BIT(1) DEFAULT 1")
    val accountNonExpired: Boolean = true,

    @Column(nullable = false, columnDefinition = "BIT(1) DEFAULT 1")
    val accountNonLocked: Boolean = true,

    @Column(nullable = false, columnDefinition = "BIT(1) DEFAULT 1")
    val credentialsNonExpired: Boolean = true
) : UserDetails {

    override fun getUsername(): String = username
    override fun getPassword(): String = password
    override fun isEnabled(): Boolean = enabled
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities
    override fun isAccountNonExpired(): Boolean = accountNonExpired
    override fun isCredentialsNonExpired(): Boolean = credentialsNonExpired
    override fun isAccountNonLocked(): Boolean = accountNonLocked
}