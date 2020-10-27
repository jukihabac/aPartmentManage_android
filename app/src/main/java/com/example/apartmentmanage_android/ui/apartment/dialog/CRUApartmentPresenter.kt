package com.example.apartmentmanage_android.ui.apartment.dialog

import com.example.apartmentmanage_android.data.repositories.local.FamilyRepository
import com.example.apartmentmanage_android.data.repositories.local.RegionRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CRUApartmentPresenter @Inject constructor(
    private var view: CRUApartmentContract.View?,
    private val mFamilyRepository: FamilyRepository,
    private val mRegionRepository: RegionRepository
) :
    CRUApartmentContract.Presenter {

    private val mCompositeDisposable = CompositeDisposable()

    override fun getRegionIDs() {
        val disposable = mRegionRepository.getRegions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.onSuccessRegionIDs(it)
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

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onDestroy() {
        mCompositeDisposable.clear()
        view = null
    }
}
