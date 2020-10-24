package com.example.apartmentmanage_android.data.repositories.local

import android.content.Context
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.RegionEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface RegionRepository {
    fun getRegions(): Observable<List<RegionEntity>>

    fun insertRegion(regionEntity: RegionEntity): Completable

    fun deleteRegionByID(regionID: String): Single<Int>

    fun updateRegion(regionEntity: RegionEntity): Completable
}

class RegionRepositoryImpl @Inject constructor(private val context: Context) :
    RegionRepository {

    private var mRegionDao = DatabaseLocal.getDatabase(context).getRegionDao()

    override fun getRegions(): Observable<List<RegionEntity>> = mRegionDao.getRegions()

    override fun insertRegion(regionEntity: RegionEntity): Completable =
        mRegionDao.insertRegion(regionEntity)

    override fun deleteRegionByID(regionID: String): Single<Int> =
        mRegionDao.deleteRegionByID(regionID)

    override fun updateRegion(regionEntity: RegionEntity): Completable =
        mRegionDao.updateRegion(regionEntity)
}
