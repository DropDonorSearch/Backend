package ru.donorsearch.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "journal", schema = "donor_search")
open class Journal (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journal_id")
    open var journalId: Long,

    @Column(name = "author")
    open var author: String,

    @Column(name = "title")
    open var title: String,

    @Column(name = "description")
    open var description: String,

    @Column(name = "created")
    open var created: LocalDateTime?,

    @Column(name = "updated")
    open var updated: LocalDateTime? = null,
) {
    @PrePersist
    open fun prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    open fun preUpdate() {
        updated = LocalDateTime.now();
    }
}