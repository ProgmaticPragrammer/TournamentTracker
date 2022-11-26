package com.usefulapps.tournamenttracker.data.source

import com.usefulapps.tournamenttracker.data.Tournament

class LocalTournamentDataSource : TournamentDataSource {

    private val tournaments = mutableListOf<Tournament>()

    override fun getAllTournaments(): List<Tournament> = tournaments

    override fun getTournament(id: Int): Tournament = tournaments[id]

    override fun addTournament(tournament: Tournament) {
        tournaments.add(tournament)
    }

}