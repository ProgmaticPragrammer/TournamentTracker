package com.usefulapps.tournamenttracker.ui.alltournaments

import androidx.lifecycle.ViewModel
import com.usefulapps.tournamenttracker.data.source.TournamentDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class AllTournamentsViewModel @Inject constructor(
    private val tournamentDataSource: TournamentDataSource,
) : ViewModel() {

    fun getTournaments() = tournamentDataSource.getAllTournaments()
}