package com.example.apartmentmanage_android.ui.signin

import com.example.apartmentmanage_android.data.repositories.local.AccountRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    private var view: SignInContract.View?,
    private val mAccountRepository: AccountRepository
) :
    SignInContract.Presenter {
    private val mCompositeDisposable = CompositeDisposable()

    override fun onSignIn(username: String, password: String) {
        val disposable = mAccountRepository.signIn(username, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                view?.onSignInSuccess(it)
            }, {
                view?.onSignInError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        this.view = null
    }
}
