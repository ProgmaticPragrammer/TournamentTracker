package com.usefulapps.tournamenttracker.data

/**
 * @param player1Won only means something if [completed] is true
 */
data class Match(
    val player1: Player,
    val player2: Player,
    val score1: Int = 0,
    val score2: Int = 0,
    val completed: Boolean = false,
    val player1Won: Boolean = false,
)
