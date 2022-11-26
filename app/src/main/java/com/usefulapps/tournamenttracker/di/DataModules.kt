package com.usefulapps.tournamenttracker.di

import com.usefulapps.tournamenttracker.data.source.LocalTournamentDataSource
import com.usefulapps.tournamenttracker.data.source.TournamentDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModules {
    @Singleton
    @Provides
    fun provideTournamentDataSource(): TournamentDataSource = LocalTournamentDataSource()
}