package com.example.apartmentmanage_android.ui.contract

import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ContractPresenter @Inject constructor(private var view: ContractContract.View?) :
    ContractContract.Presenter {
    private val mCompositeDisposable = CompositeDisposable()

    override fun getContracts() {

    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        view = null
    }
}
