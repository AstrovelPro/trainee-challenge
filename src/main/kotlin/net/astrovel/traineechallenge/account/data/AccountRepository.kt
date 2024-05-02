package net.astrovel.traineechallenge.account.data

import net.astrovel.traineechallenge.account.domain.Account
import org.springframework.data.jpa.repository.JpaRepository


interface AccountRepository : JpaRepository<Account, Long>
