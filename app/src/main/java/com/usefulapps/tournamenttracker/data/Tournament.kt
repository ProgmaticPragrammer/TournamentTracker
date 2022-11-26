package com.usefulapps.tournamenttracker.data

/**
 * The Tournament is determined by a format and that format dictates which
 * matches need to be played.
 *
 * For now, let's assume there will only be round robin tournaments.
 * That means once a tournament is made, all the matches will be created immediately
 */
data class Tournament(val players: List<Player>, val matches: List<Match>,)
