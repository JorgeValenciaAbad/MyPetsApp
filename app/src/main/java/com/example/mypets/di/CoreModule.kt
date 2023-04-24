package com.example.mypets.di

import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.data.remote.MyPetsApi
import com.example.mypets.ui.details.DetailsViewModel
import com.example.mypets.ui.login.LoginViewModel
import com.example.mypets.ui.pet.PetViewModel
import com.example.mypets.ui.profile.ProfileViewModel
import com.example.mypets.ui.register.RegisterViewModel
import com.example.mypets.util.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideRetrofitLogin(): MyPetsApi {
        val gson = GsonBuilder()
            .setLenient()
            .create()


        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(MyPetsApi::class.java)
    }

    @Singleton
    @Provides
    fun providesMyPetsRepositoryImpl(myPetsApi: MyPetsApi):MyPetsRepositoryImpl{
        return MyPetsRepositoryImpl(myPetsApi)
    }
    @Singleton
    @Provides
    fun providesLoginViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): LoginViewModel {
        return LoginViewModel(myPetsRepositoryImpl)
    }
    @Singleton
    @Provides
    fun providesPetViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl):PetViewModel{
        return PetViewModel(myPetsRepositoryImpl)
    }

    @Singleton
    @Provides
    fun providesRegisterViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): RegisterViewModel {
        return RegisterViewModel(myPetsRepositoryImpl)
    }

    @Singleton
    @Provides
    fun providesProfileViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): ProfileViewModel {
        return ProfileViewModel(myPetsRepositoryImpl)
    }

    @Singleton
    @Provides
    fun providesDetailsViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): DetailsViewModel {
        return DetailsViewModel(myPetsRepositoryImpl)
    }

}