package com.casti.gametrackpoc.games.game.data;

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.Date

@Table
data class User(
        var id: String?,
        val username: String,
        val playedGames: List<PlayedGame>
)

@Table("GAMES")
data class Game(
        @Id var id: String?,
        val gamename: String,
        val gamelength: Int,
        val description: String?,
        val thumbnail: String
)

@Table("PlayedGames")
data class PlayedGame(
        @Id var id: String?,
        val gameId: String?,
        val playingStatus: Int,
        val howMuchLikedScore: Int,
        val expectation: Int,
        val beated: Beated,
)

data class Beated(val beated: Boolean, val beatedDate: Date)

fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
}