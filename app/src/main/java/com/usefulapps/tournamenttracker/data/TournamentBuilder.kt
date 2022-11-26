package com.usefulapps.tournamenttracker.data

class TournamentBuilder {

    private var numPlayers = 0

    fun setNumPlayers(numPlayers: Int) = apply {
        this.numPlayers = numPlayers
    }

    fun build(): Tournament {
        val players = mutableListOf<Player>()
        repeat(numPlayers) {
            players.add(Player("Player$it"))
        }
        val matches = mutableListOf<Match>()
        for (player1 in players) {
            for (player2 in players) {
                if (player1 == player2) continue
                matches.add(Match(player1, player2))
            }
        }
        return Tournament(players, matches)
    }
}