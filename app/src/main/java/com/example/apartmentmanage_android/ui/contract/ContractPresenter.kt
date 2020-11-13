package com.example.apartmentmanage_android.ui.contract

import com.example.apartmentmanage_android.data.repositories.local.ContractRepository
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ContractPresenter @Inject constructor(
    private var view: ContractContract.View?,
    private var mContractRepository: ContractRepository
) :
    ContractContract.Presenter {
    private val mCompositeDisposable = CompositeDisposable()

    override fun getContracts() {
        val disposable = mContractRepository.getContracts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccessGetContracts(it)
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun addContract(contractEntity: ContractEntity) {
        val disposable = mContractRepository.insertContract(contractEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccessAddContract(contractEntity)
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun deleteContract(contractID: String) {
        val disposable = mContractRepository.deleteContractByID(contractID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccessDeleteContract(contractID)
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun updateContract(contractEntity: ContractEntity) {
        val disposable = mContractRepository.updateContract(contractEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccessUpdateContract(contractEntity)
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        view = null
    }
}
