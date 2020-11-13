package com.example.apartmentmanage_android.ui.contract.dialog

import com.example.apartmentmanage_android.data.repositories.local.ApartmentRepository
import com.example.apartmentmanage_android.data.repositories.local.ContractRepository
import com.example.apartmentmanage_android.data.repositories.local.EmployeeRepository
import com.example.apartmentmanage_android.data.repositories.local.FamilyRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CRUContractPresenter @Inject constructor(
    private var view: CRUContractContract.View?,
    private var mContractRepository: ContractRepository,
    private var mFamilyRepository: FamilyRepository,
    private var mApartmentRepository: ApartmentRepository,
    private var mEmployeeRepository: EmployeeRepository
) : CRUContractContract.Presenter {

    private var mCompositeDisposable = CompositeDisposable()

    override fun getEmployeeIDs() {
        val disposable = mEmployeeRepository.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.onSuccessEmployeeIDs(it)
                },
                {
                    view?.onError(it.localizedMessage)
                })
        mCompositeDisposable.add(disposable)
    }

    override fun getApartmentIDs() {
        val disposable = mApartmentRepository.getApartments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.onSuccessApartmentIDs(it)
                },
                {
                    view?.onError(it.localizedMessage)
                })
        mCompositeDisposable.add(disposable)
    }

    override fun getFamilyIDs() {
        val disposable = mFamilyRepository.getFamily()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.onSuccessFamilyIDs(it)
                },
                {
                    view?.onError(it.localizedMessage)
                })
        mCompositeDisposable.add(disposable)
    }

    override fun sumCost() {
        //No-op
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        view = null
    }
}
