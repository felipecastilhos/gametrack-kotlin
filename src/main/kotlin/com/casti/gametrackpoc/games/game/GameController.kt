package com.casti.gametrackpoc.games.game

import com.casti.gametrackpoc.GameService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(val service: GameService) {
    @GetMapping("/games")
    fun index(): List<Game> = service.findGames()

    @PostMapping("/games")
    fun post(@RequestBody game: Game) {
        service.save(game)
    }
}