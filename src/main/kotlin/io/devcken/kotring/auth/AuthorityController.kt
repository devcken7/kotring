package io.devcken.kotring.auth

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("authorities")
class AuthorityController(
    val authorityService: AuthorityService
) {

    @GetMapping
    fun authorities(@RequestParam role: Role): ResponseEntity<List<Authority>> = ok(authorityService.authorities(role))

    @PostMapping
    fun save(@RequestBody authority: Authority): ResponseEntity<Authority> = ok(authorityService.save(authority))
}