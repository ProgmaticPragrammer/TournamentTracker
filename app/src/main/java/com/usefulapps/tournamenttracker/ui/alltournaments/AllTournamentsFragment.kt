package com.usefulapps.tournamenttracker.ui.alltournaments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.usefulapps.tournamenttracker.R
import com.usefulapps.tournamenttracker.data.Tournament
import com.usefulapps.tournamenttracker.ui.utils.getDimen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTournamentsFragment : Fragment() {

    private val viewModel by viewModels<AllTournamentsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val container = LinearLayout(context)
        for ((idx, tournament) in viewModel.getTournaments().withIndex()) {
            container.addView(createMatchItem(tournament, idx))
        }
        return container
    }

    private fun createMatchItem(tournament: Tournament, tournamentId: Int): View {
        val context = requireContext()
        val container = FrameLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                MATCH_PARENT, R.dimen.all_tournaments_tournament_height.getDimen(context)
            )
            setOnClickListener {
                this.findNavController().navigate(
                AllTournamentsFragmentDirections.actionAlltournmentsToViewtournament(tournamentId))
            }
        }
        TextView(context).apply {
            text = tournament.players.joinToString { it.name }
        }.also {
            container.addView(
                it,
                FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.CENTER)
            )
        }
        return container
    }
}