package com.usefulapps.tournamenttracker.ui.utils

import android.content.Context

fun Int.getString(context: Context) = context.getString(this)

fun Int.getDimen(context: Context) = context.resources.getDimensionPixelSize(this)