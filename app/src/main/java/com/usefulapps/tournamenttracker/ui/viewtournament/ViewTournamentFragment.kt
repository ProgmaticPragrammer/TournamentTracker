package com.usefulapps.tournamenttracker.ui.viewtournament

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.FrameLayout.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.usefulapps.tournamenttracker.R
import com.usefulapps.tournamenttracker.data.Player
import com.usefulapps.tournamenttracker.ui.alltournaments.AllTournamentsViewModel
import com.usefulapps.tournamenttracker.ui.utils.getDimen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewTournamentFragment : Fragment() {

    private val viewModel by viewModels<ViewTournamentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }

        for (player in viewModel.players) {
            Log.d("Blaap", "Player $player")
            container.addView(getPlayerView(player))
        }
        return container
    }

    private fun getPlayerView(player: Player): View {
        val context = requireContext()
        val container = FrameLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                MATCH_PARENT,
                R.dimen.view_tournament_player_height.getDimen(context)
            )
        }
        TextView(context).apply {
            text = player.name
        }.also {
            container.addView(
                it,
                FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.CENTER)
            )
        }
        return container
    }
}