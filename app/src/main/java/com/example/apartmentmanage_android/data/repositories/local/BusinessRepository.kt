package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.BusinessEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface BusinessRepository {

    fun insertBusiness(businessEntity: BusinessEntity): Completable

    fun updateBusiness(businessEntity: BusinessEntity): Completable

    fun deleteBusinessByID(businessID: String): Single<Int>

    fun getBusiness(): Observable<List<BusinessEntity>>
}

class BusinessRepositoryImpl @Inject constructor(private val context: Context) :
    BusinessRepository {

    private var mBusinessDao = DatabaseLocal.getDatabase(context).getBusinessDao()

    override fun insertBusiness(businessEntity: BusinessEntity): Completable {
        return mBusinessDao.insertBusiness(businessEntity)
    }

    override fun updateBusiness(businessEntity: BusinessEntity): Completable {
        return mBusinessDao.updateBusiness(businessEntity)
    }

    override fun deleteBusinessByID(businessID: String): Single<Int> {
        return mBusinessDao.deleteBusinessByID(businessID)
    }

    override fun getBusiness(): Observable<List<BusinessEntity>> {
        return mBusinessDao.getBusiness()
    }
}
