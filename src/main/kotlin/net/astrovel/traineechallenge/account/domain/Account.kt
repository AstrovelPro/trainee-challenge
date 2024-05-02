    package net.astrovel.traineechallenge.account.domain

    import jakarta.persistence.*

    @Entity
    data class Account(
        @Id
        val id: Long = 1L,
        val description: String = "null",
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(
            name = "market_account",
            joinColumns = [JoinColumn(name = "account_id")],
            inverseJoinColumns = [JoinColumn(name = "market_id")]
        )
        val markets: List<Market> = emptyList()
    )