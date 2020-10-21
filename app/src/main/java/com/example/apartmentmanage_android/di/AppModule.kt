package com.example.apartmentmanage_android.di

import android.app.Application
import android.content.Context
import com.example.testquestion.data.source.shareprefs.SharedPrefs
import com.example.testquestion.data.source.shareprefs.SharedPrefsImpl
import com.example.apartmentmanage_android.di.scopes.AppScoped
import dagger.Binds
import dagger.Module

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
