package com.casti.gametrackpoc

import com.casti.gametrackpoc.games.game.Game
import com.casti.gametrackpoc.games.game.GameRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@SpringBootApplication
class GametrackPocApplication

fun main(args: Array<String>) {
    runApplication<GametrackPocApplication>(*args)
}

@RestController
class GameController(val service: GameService) {
    @GetMapping("/games")
    fun index(): List<Game> = service.findGames()

    @PostMapping("/games")
    fun post(@RequestBody game: Game) {
        service.save(game)
    }
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
