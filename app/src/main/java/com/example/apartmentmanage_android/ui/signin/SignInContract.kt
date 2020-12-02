package com.example.apartmentmanage_android.ui.signin

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import com.example.apartmentmanage_android.ui.BasePresenter

interface SignInContract {
    interface Presenter : BasePresenter {
        fun onSignIn(username: String, password: String)
    }

    interface View {
        fun onSignInSuccess(accountEntity: AccountEntity)
        fun onSignInError(message: String?)
        fun onGetError(message: String?)
    }
}
