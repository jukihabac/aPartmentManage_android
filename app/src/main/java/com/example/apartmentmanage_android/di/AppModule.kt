package com.example.apartmentmanage_android.di

import android.app.Application
import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.shareprefs.SharedPrefs
import com.example.apartmentmanage_android.data.source.local.shareprefs.SharedPrefsImpl
import com.example.apartmentmanage_android.di.scopes.AppScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule.AppAbstractModule::class])
class AppModule {

    @Module
    interface AppAbstractModule {
        @AppScoped
        @Binds
        fun bindApplicationContext(application: Application): Context

        @AppScoped
        @Binds
        fun bindSharedPreference(sharedPrefs: SharedPrefsImpl): SharedPrefs
    }
}
