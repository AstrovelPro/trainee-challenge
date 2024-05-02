package net.astrovel.traineechallenge.config

import java.util.concurrent.ThreadLocalRandom

object IdGenerator {
    fun generateId() =
        ThreadLocalRandom.current().nextLong()

}
