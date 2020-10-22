package com.example.apartmentmanage_android.app

import android.app.Application
import com.example.apartmentmanage_android.di.ActivityBindingModule
import com.example.apartmentmanage_android.di.AppModule
import com.example.apartmentmanage_android.di.FragmentBindingModule
import com.example.apartmentmanage_android.di.RepositoryLocalModule
import com.example.apartmentmanage_android.di.scopes.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(
    modules = [
        AppModule::class,
        RepositoryLocalModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent :
    AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
