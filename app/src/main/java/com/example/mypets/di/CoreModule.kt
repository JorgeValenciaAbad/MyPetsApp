package com.example.mypets.di

import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.ui.pet.PetViewModel
import com.example.mypets.ui.register.RegisterViewModel
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
    fun providesAdoptionViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl):PetViewModel{
        return PetViewModel(myPetsRepositoryImpl)
    }

    @Singleton
    @Provides
    fun providesRegisterViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): RegisterViewModel {
        return RegisterViewModel(myPetsRepositoryImpl)
    }


}