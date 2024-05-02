package net.astrovel.traineechallenge.account.domain

import jakarta.persistence.*

@Entity
data class Market(
    @Id
    val id: Long = 1L,
    val code: String = "null",
    val description: String = "null",
    val country: Country? = Country.ARGENTINA,
    @ManyToMany(mappedBy = "markets")
    val accounts: List<Account> = emptyList()
)