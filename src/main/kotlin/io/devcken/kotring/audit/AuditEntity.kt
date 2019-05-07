package io.devcken.kotring.audit

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*

@EntityListeners(value = arrayOf(AuditingEntityListener::class))
@MappedSuperclass
abstract class AuditEntity<U, ID : Number> {
    @Id @GeneratedValue
    val id: Int = 0

    @ManyToOne
    @JoinColumn(name = "created_by", updatable = false)
    @CreatedBy
    @JsonIgnore
    var createdBy: U? = null

    @ManyToOne
    @JoinColumn(name = "last_modified_by")
    @LastModifiedBy
    @JsonIgnore
    var lastModifiedBy: U? = null

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDate: Instant? = null

    @LastModifiedDate
    var lastModifiedDate: Instant? = null
}