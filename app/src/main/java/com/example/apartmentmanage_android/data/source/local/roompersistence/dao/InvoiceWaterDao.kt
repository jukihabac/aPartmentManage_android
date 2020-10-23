package com.example.apartmentmanage_android.data.source.local.roompersistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.InvoiceWaterEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface InvoiceWaterDao {

    @Query("SELECT * FROM InvoiceWater")
    fun getInvoiceWater(): Observable<List<InvoiceWaterEntity>>

    @Insert
    fun insertInvoiceWater(invoiceWaterEntity: InvoiceWaterEntity): Completable

    @Query("DELETE FROM InvoiceWater WHERE InvoiceWaterID =:invoiceElectricID")
    fun deleteInvoiceWaterByID(invoiceElectricID: String): Single<Int>

    @Update
    fun updateInvoiceWater(invoiceWaterEntity: InvoiceWaterEntity): Completable

}
