package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface FamilyRepository {
    fun getFamily(): Observable<List<FamilyEntity>>

    fun insertFamily(familyEntity: FamilyEntity): Completable

    fun deleteFamilyByID(familyID: String): Single<Int>

    fun updateFamily(familyEntity: FamilyEntity): Completable
}

class FamilyRepositoryImpl @Inject constructor(private val context: Context) :
    FamilyRepository {

    private var mFamilyDao = DatabaseLocal.getDatabase(context).getFamilyDao()

    override fun getFamily(): Observable<List<FamilyEntity>> = mFamilyDao.getFamily()

    override fun insertFamily(familyEntity: FamilyEntity): Completable =
        mFamilyDao.insertFamily(familyEntity)

    override fun deleteFamilyByID(familyID: String): Single<Int> =
        mFamilyDao.deleteFamilyByID(familyID)

    override fun updateFamily(familyEntity: FamilyEntity): Completable =
        mFamilyDao.updateFamily(familyEntity)
}
