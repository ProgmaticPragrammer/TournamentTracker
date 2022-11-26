package com.usefulapps.tournamenttracker.data.source

import com.usefulapps.tournamenttracker.data.Tournament

interface TournamentDataSource {

    fun getAllTournaments(): List<Tournament>

    fun getTournament(id: Int): Tournament

    fun addTournament(tournament: Tournament)
}