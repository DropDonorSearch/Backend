package ru.donorsearch.model.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "bonus", schema = "donor_search")
open class Bonus (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bonus_id")
    open var bonusId: Long? = null,

    @Column(name = "avatar_url")
    open var imageUrl: String? = null,

    @Column(name = "title")
    open var title: String,

    @Column(name = "description")
    open var description: String? = null,

    @Column(name = "promo")
    open var promo: String,

    @Column(name = "expiration_date")
    open var expirationDate: LocalDate? = null,

    @ManyToMany
    @JoinTable(
        name = "users_bonuses",
        schema = "donor_search",
        joinColumns = [JoinColumn(name = "bonus_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    open var users: MutableList<User>? = mutableListOf(),

    @Column(name = "created_at")
    open var created: LocalDateTime,

    @Column(name = "updated_at")
    open var updated: LocalDateTime? = null
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