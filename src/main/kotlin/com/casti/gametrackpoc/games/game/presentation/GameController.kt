package com.casti.gametrackpoc.games.game.presentation

import com.casti.gametrackpoc.GameService
import com.casti.gametrackpoc.games.game.data.Game
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(val service: GameService) {
    @GetMapping(GameEndpoints.Games.route)
    fun index(): List<Game> = service.findGames()

    @PostMapping(GameEndpoints.Games.route)
    fun post(@RequestBody game: Game) {
        service.save(game)
    }
}

sealed class GameEndpoints {
    object Games: GameEndpoints() {
        const val route = "/games/"
    }
}