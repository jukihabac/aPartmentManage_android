package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.DetailBusinessEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface DetailBusinessRepository {

    fun getDetailBusiness(): Observable<List<DetailBusinessEntity>>

    fun getDetailBusinessByID(businessID: String): Observable<DetailBusinessEntity>

    fun insertDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable

    fun deleteDetailBusinessByID(businessID: String): Single<Int>

    fun updateDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable
}

class DetailBusinessRepositoryImpl @Inject constructor(private val context: Context) :
    DetailBusinessRepository {

    private var mDetailBusinessDao = DatabaseLocal.getDatabase(context).getDetailBusinessDaoDao()

    override fun getDetailBusiness(): Observable<List<DetailBusinessEntity>> =
        mDetailBusinessDao.getDetailBusiness()

    override fun getDetailBusinessByID(businessID: String): Observable<DetailBusinessEntity> =
        mDetailBusinessDao.getDetailBusinessByID(businessID)

    override fun insertDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable =
        mDetailBusinessDao.insertDetailBusiness(detailBusinessEntity)

    override fun deleteDetailBusinessByID(businessID: String): Single<Int> =
        mDetailBusinessDao.deleteDetailBusinessByID(businessID)

    override fun updateDetailBusiness(detailBusinessEntity: DetailBusinessEntity): Completable =
        mDetailBusinessDao.updateDetailBusiness(detailBusinessEntity)
}
