package com.example.apartmentmanage_android.ui.signin

import android.os.Bundle
import android.widget.Toast
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.AccountEntity
import com.example.apartmentmanage_android.ui.BaseActivity
import com.example.apartmentmanage_android.utils.PatternUtils
import kotlinx.android.synthetic.main.activity_sign_in.*
import javax.inject.Inject

class SignInActivity : BaseActivity(), SignInContract.View {

    @Inject
    lateinit var mPresenter: SignInContract.Presenter

    @Inject
    lateinit var mNavigator: SignInNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        handleEvents()
    }

    override fun onStart() {
        mPresenter.onStart()
        super.onStart()
    }

    override fun onStop() {
        mPresenter.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    override fun onSignInSuccess(accountEntity: AccountEntity) {
        mNavigator.navigateToMain(accountEntity)
        finish()
    }

    override fun onSignInError(message: String?) {
        usernameTextInputLayout.error = getString(R.string.could_not_find_your_account)
        passwordTextInputLayout.error = getString(R.string.wrong_password_try_again)
    }

    override fun onGetError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun handleEvents() {
        loginButton.setOnClickListener {
            if (validateUsername() || validatePassword()) {
                mPresenter.onSignIn(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
    }

    private fun validateUsername(): Boolean {
        return if (usernameEditText.text.toString().isEmpty()) {
            usernameTextInputLayout.error = getString(R.string.enter_username)
            false
        } else if (!PatternUtils.USERNAME_PATTERN.matcher(usernameEditText.text.toString())
                .matches()
        ) {
            usernameTextInputLayout.error =
                getString(R.string.enter_combination_of_at_least_five_numbers_and_letters)
            false
        } else {
            usernameTextInputLayout.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        return if (passwordEditText.text.toString().isEmpty()) {
            passwordTextInputLayout.error = getString(R.string.enter_password)
            false
        } else if (!PatternUtils.PASSWORD_PATTERN.matcher(passwordEditText.text.toString())
                .matches()
        ) {
            passwordTextInputLayout.error = getString(R.string.enter_password)
            false
        } else {
            passwordTextInputLayout.error = null
            true
        }
    }
}
