package com.usefulapps.tournamenttracker.ui.newtournament

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usefulapps.tournamenttracker.data.TournamentBuilder
import com.usefulapps.tournamenttracker.data.source.TournamentDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class NewTournamentViewModel @Inject constructor(
    private val tournamentDataSource: TournamentDataSource,
) : ViewModel() {

    suspend fun start(numPlayers: Int) = viewModelScope.launch {
        TournamentBuilder()
            .setNumPlayers(numPlayers)
            .build()
            .also {
                tournamentDataSource.addTournament(it)
            }
    }
}