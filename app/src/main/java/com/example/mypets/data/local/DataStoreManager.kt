package com.example.mypets.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


class DataStoreManager(private val context: Context){

    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="DataStore")
        private val TOKEN_USER = stringPreferencesKey("token")

    }

    suspend fun getToken(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[TOKEN_USER]

    }
    suspend fun saveToken(token:String){
        context.dataStore.edit { preferences->
            preferences[TOKEN_USER] = token
            Log.d("TOKEN", token)
        }
    }

}