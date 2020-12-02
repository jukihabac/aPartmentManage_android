package com.example.apartmentmanage_android.ui.signin

import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import com.example.apartmentmanage_android.ui.main.MainActivity
import com.example.apartmentmanage_android.utils.ActivityUtils
import javax.inject.Inject

interface SignInNavigator {
    fun navigateToMain(accountEntity: AccountEntity)
}

class SignInNavigatorImpl @Inject constructor(private val signInActivity: SignInActivity) :
    SignInNavigator {
    override fun navigateToMain(accountEntity: AccountEntity) {
        ActivityUtils.startWithBundleSlideAnimation(
            signInActivity,
            MainActivity.newInstance(signInActivity, accountEntity)
        )
    }
}
