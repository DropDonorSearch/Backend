package ru.donorsearch.model.entity

import jakarta.persistence.*
import ru.donorsearch.model.entity.enums.SpecialProjectStatusEnum
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "special_project", schema = "donor_search")
open class SpecialProject (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_project_id")
    open var specialProjectId: Long,

    @Column(name = "image_url")
    open var imageUrl: String,

    @Column(name = "status")
    open var status: SpecialProjectStatusEnum,

    @Column(name = "date")
    open var date: LocalDate,

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