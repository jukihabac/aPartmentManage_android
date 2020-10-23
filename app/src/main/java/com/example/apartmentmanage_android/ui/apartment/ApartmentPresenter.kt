package com.example.apartmentmanage_android.ui.apartment

import com.example.apartmentmanage_android.data.repositories.local.ApartmentRepository
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApartmentPresenter @Inject constructor(
    private var view: ApartmentContract.View?,
    private var mApartmentRepository: ApartmentRepository
) :
    ApartmentContract.Presenter {
    private val mCompositeDisposable = CompositeDisposable()

    override fun getApartments() {
        val disposable = mApartmentRepository.getApartments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccessGetApartment(it)
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun deleteApartment(apartmentID: String) {
        val disposable = mApartmentRepository.deleteApartment(apartmentID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccess()
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun updateApartment(apartmentEntity: ApartmentEntity) {
        val disposable = mApartmentRepository.updateApartment(apartmentEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccess()
            }, {
                view?.onError(it.localizedMessage)
            })
        mCompositeDisposable.add(disposable)
    }

    override fun addApartment(apartmentEntity: ApartmentEntity) {
        val disposable = mApartmentRepository.insertApartments(apartmentEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onSuccess()
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
