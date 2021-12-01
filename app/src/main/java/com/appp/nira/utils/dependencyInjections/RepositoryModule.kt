package com.appp.nira.utils.dependencyInjections

import com.appp.nira.data.repository.LoanCalculatorRepository
import com.appp.nira.data.repository.SplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    @ViewModelScoped
    fun provideSplashRepository(
    ): SplashRepository {
        return SplashRepository()
    }

    @Provides
    @ViewModelScoped
    fun provideLoanCalculatorRepository(
    ): LoanCalculatorRepository {
        return LoanCalculatorRepository()
    }
}
