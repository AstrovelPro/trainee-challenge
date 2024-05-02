package net.astrovel.traineechallenge.account.rest.dto

data class AccountDTO(
    val id: Long,
    val description: String,
    val markets: List<MarketDTO>
)
