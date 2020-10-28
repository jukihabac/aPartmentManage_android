package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.dao.ApartmentDao
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface ApartmentRepository {
    fun insertApartments(apartmentEntity: ApartmentEntity): Completable

    fun updateApartment(apartmentEntity: ApartmentEntity): Completable

    fun deleteApartment(apartmentID: String): Single<Int>

    fun getApartments(): Observable<List<ApartmentEntity>>

    fun getApartmentByID(apartmentID: String): Observable<ApartmentEntity>
}

class ApartmentRepositoryImpl @Inject constructor(private val context: Context) :
    ApartmentRepository {

    private var mApartmentDao = DatabaseLocal.getDatabase(context).getApartmentDao()

    override fun insertApartments(apartmentEntity: ApartmentEntity): Completable {
        return mApartmentDao.insertApartment(apartmentEntity)
    }

    override fun updateApartment(apartmentEntity: ApartmentEntity): Completable {
        return mApartmentDao.updateApartment(apartmentEntity)
    }

    override fun deleteApartment(apartmentID: String): Single<Int> {
        return mApartmentDao.deleteApartmentByID(apartmentID)
    }

    override fun getApartments(): Observable<List<ApartmentEntity>> {
        return mApartmentDao.getApartments()
    }

    override fun getApartmentByID(apartmentID: String): Observable<ApartmentEntity> {
        return mApartmentDao.getApartmentByID(apartmentID)
    }
}
