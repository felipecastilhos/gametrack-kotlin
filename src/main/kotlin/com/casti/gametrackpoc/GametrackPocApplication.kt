package com.casti.gametrackpoc

import com.casti.gametrackpoc.games.game.data.Game
import com.casti.gametrackpoc.games.game.domain.GameRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import java.util.*

@SpringBootApplication
class GametrackPocApplication

fun main(args: Array<String>) {
    runApplication<GametrackPocApplication>(*args)
}

@Service
class GameService(val db: GameRepository) {
    fun findGames(): List<Game> = db.findAll().toList()

    //TODO: move this extension to a more appropriated file
    fun <T : Any> Optional<out T>.toList(): List<T> =
            if (isPresent) listOf(get()) else emptyList()

    fun save(game: Game) {
        db.save(game)
    }
}
