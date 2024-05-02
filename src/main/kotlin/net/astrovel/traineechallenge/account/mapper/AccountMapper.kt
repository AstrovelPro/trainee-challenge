package net.astrovel.traineechallenge.account.mapper

import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.domain.Country
import net.astrovel.traineechallenge.account.domain.Market
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import net.astrovel.traineechallenge.account.rest.dto.MarketDTO
fun Account.toDto() = AccountDTO(
    id = id,
    description = description,
    markets = markets.map(Market::toDto)
)

fun Market.toDto() = MarketDTO(
    id = id,
    code = code,
    description = description,
    country = country?.name ?: "Unknown"
)

fun AccountDTO.toEntity(markets: List<Market> = listOf()): Account {
    return Account(
        id = id,
        description = description,
        markets = markets
    )
}

fun MarketDTO.toEntity(): Market {
    return Market(
        id = id,
        code = code,
        description = description,
        country = Country.valueOf(country)
    )
}

