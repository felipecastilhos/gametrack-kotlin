package com.casti.gametrackpoc.games.game.domain

import com.casti.gametrackpoc.games.game.data.Game
import org.springframework.data.repository.CrudRepository

interface GameRepository: CrudRepository<Game,String>