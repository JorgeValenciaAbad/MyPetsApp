package com.example.mypets.di

import android.content.Context
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.data.local.DataStoreManager
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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Singleton
    @Provides
    fun providerDataStore(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): MyPetsApi {
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
    fun providesMyPetsRepositoryImpl(
        myPetsApi: MyPetsApi,
        dataStore: DataStoreManager
    ): MyPetsRepositoryImpl {
        return MyPetsRepositoryImpl(myPetsApi, dataStore)
    }

    @Singleton
    @Provides
    fun providesLoginViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): LoginViewModel {
        return LoginViewModel(myPetsRepositoryImpl)
    }

    @Singleton
    @Provides
    fun providesPetViewModel(myPetsRepositoryImpl: MyPetsRepositoryImpl): PetViewModel {
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
    @Provides
    fun providesIsLogIn(dataStore: DataStoreManager): Boolean {
         val flag: Boolean
         runBlocking {
             flag = dataStore.getToken().isNullOrEmpty()
         }
        return flag
    }

}