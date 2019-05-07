package io.devcken.kotring.category

import io.devcken.kotring.audit.AuditEntity
import io.devcken.kotring.auth.Account
import org.hibernate.envers.Audited
import org.hibernate.envers.RelationTargetAuditMode
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table
@Audited(auditParents = [AuditEntity::class], targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
data class Category(
    @Column(nullable = false)
    val name: String
) : AuditEntity<Account, Int>()