package com.example.apartmentmanage_android.ui.signin

import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import dagger.Binds
import dagger.Module

@Module(includes = [SignInModule.SignInModuleAbstractModule::class])
class SignInModule {

    @Module
    interface SignInModuleAbstractModule {
        @ActivityScoped
        @Binds
        fun bindSignInView(view: SignInActivity): SignInContract.View

        @ActivityScoped
        @Binds
        fun bindSignInPresenter(presenter: SignInPresenter): SignInContract.Presenter

        @ActivityScoped
        @Binds
        fun bindSignInNavigator(navigator: SignInNavigatorImpl): SignInNavigator
    }
}
