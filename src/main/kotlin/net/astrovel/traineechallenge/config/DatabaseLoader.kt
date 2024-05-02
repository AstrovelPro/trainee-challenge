package net.astrovel.traineechallenge.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.domain.Country
import net.astrovel.traineechallenge.account.domain.Market
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DatabaseLoader(@PersistenceContext private val entityManager: EntityManager) : CommandLineRunner {

    @Transactional
    override fun run(vararg args: String) {
        if (isDatabaseEmpty) {
            loadDemoData()
        }
    }

    private val isDatabaseEmpty: Boolean
        get() = (entityManager.createQuery("SELECT COUNT(a) FROM Account a").singleResult as Long) == 0L

    private fun loadDemoData() {
        val marketAR1 =
            Market(IdGenerator.generateId(), "MAE", "Mercado Argentino", Country.ARGENTINA)
        val marketAR2 =
            Market(IdGenerator.generateId(), "ROFEX", "Rosario Futures Exchange", Country.ARGENTINA)
        val marketUY1 =
            Market(IdGenerator.generateId(), "UFEX", "Uruguay Futures Exchange", Country.URUGUAY)

        val markets = listOf(marketAR1, marketAR2, marketUY1)
        markets.forEach { entityManager.persist(it) }

        val rand = Random()
        for (i in 1..1000000) {
            val chosenMarket = markets[rand.nextInt(markets.size)]
            val account = Account(IdGenerator.generateId(), "Demo Account $i", listOf(chosenMarket))
            entityManager.persist(account)
        }
    }
}
