package net.astrovel.traineechallenge.account.data


import net.astrovel.traineechallenge.account.domain.Market
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MarketRepository : CrudRepository<Market, Long>