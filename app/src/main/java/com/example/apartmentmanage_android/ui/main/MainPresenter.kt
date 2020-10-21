package com.example.apartmentmanage_android.ui.main

import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private var view: MainContract.View?
) :
    MainContract.Presenter {
    private val mCompositeDisposable = CompositeDisposable()

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        view = null
    }
}
