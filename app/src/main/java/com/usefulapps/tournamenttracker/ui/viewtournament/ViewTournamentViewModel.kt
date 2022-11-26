package com.usefulapps.tournamenttracker.ui.viewtournament

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.usefulapps.tournamenttracker.R
import com.usefulapps.tournamenttracker.TournamentDestinationsArgs
import com.usefulapps.tournamenttracker.data.source.TournamentDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewTournamentViewModel @Inject constructor(
    private val tournamentDataSource: TournamentDataSource,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val tournamentId: Int by lazy {
        savedStateHandle["tournamentId"]!!
    }
    private val tournament by lazy {
        tournamentDataSource.getTournament(tournamentId)
    }

    val players = tournament.players

    val matches = tournament.matches
}