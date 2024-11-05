package com.yahyaev.goal_tracker.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

@Entity()
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(nullable = false, unique = true)
    val username : String,

    @Column(nullable = false)
    private val password : String,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt : LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    val updatedAt : LocalDateTime = LocalDateTime.now()

) : UserDetails {
    override fun getPassword() = password
    override fun getUsername() = username

    override fun getAuthorities(): Collection<GrantedAuthority> = emptyList()

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}