package ru.donorsearch.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user", schema = "donor_search")
open class User(
    @Id
    @Column(name = "external_id")
    open var externalId: Long? = null,

    @Column(name = "first_name")
    open var firstName: String? = null,

    @Column(name = "last_name")
    open var lastName: String? = null,

    @Column(name = "middle_name")
    open var middleName: String? = null,

    @Column(name = "username")
    open var username: String?,

    @Column(name = "email")
    open var email: String,

    @Column(name = "password")
    open var password: String? = null,

    @Column(name = "gender")
    open var gender: String? = null,

    @Column(name = "about")
    open var about: String? = null,

    @ManyToMany
    @JoinTable(
        name = "users_bonuses",
        schema = "donor_search",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "bonus_id")]
    )
    open var bonuses: MutableList<Bonus>? = mutableListOf(),

    @Column(name = "created")
    open var created: LocalDateTime?,

    @Column(name = "updated")
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