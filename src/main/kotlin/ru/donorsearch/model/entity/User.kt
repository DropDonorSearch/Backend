package ru.donorsearch.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user", schema = "task_manager")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open var id: Long? = null,

    @Column(name = "firstname")
    open var firstname: String? = null,

    @Column(name = "lastname")
    open var lastname: String? = null,

    @Column(name = "username")
    open var username: String,

    @Column(name = "email")
    open var email: String,

    @Column(name = "password")
    open var password: String? = null,

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