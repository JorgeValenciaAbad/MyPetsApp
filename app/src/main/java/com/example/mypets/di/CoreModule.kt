package com.example.mypets.di

import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.ui.pet.PetViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {


    @Singleton
    @Provides
    fun providesMyPetsRepositoryImpl():MyPetsRepositoryImpl{
        return MyPetsRepositoryImpl()
    }

    @Singleton
    @Provides
    fun providesAdoptionViewModel():PetViewModel{
        return PetViewModel()
    }

}