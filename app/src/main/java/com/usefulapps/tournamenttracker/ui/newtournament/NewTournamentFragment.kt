package com.usefulapps.tournamenttracker.ui.newtournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.usefulapps.tournamenttracker.R
import com.usefulapps.tournamenttracker.ui.utils.getString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTournamentFragment : Fragment() {

    private val viewModel by viewModels<NewTournamentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }

        val numPlayersEditText = EditText(context).apply {
            hint = R.string.new_tournament_num_players_hint.getString(context)
            inputType = EditorInfo.TYPE_CLASS_NUMBER
        }.also {
            container.addView(it)
        }

        Button(context).apply {
            text = R.string.new_tournament_start.getString(context)
            setOnClickListener {
                viewModel.start(Integer.parseInt(numPlayersEditText.text.toString()))
            }
        }.also {
            container.addView(it)
        }

        return container
    }
}