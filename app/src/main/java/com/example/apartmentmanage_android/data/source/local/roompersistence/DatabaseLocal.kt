package com.example.apartmentmanage_android.data.source.local.roompersistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal.Companion.VERSION_DATABASE
import com.example.apartmentmanage_android.data.source.local.roompersistence.dao.*
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.*

@Database(
    entities = [
        AccountEntity::class,
        ApartmentEntity::class,
        BusinessEntity::class,
        ContractEntity::class,
        DetailBusinessEntity::class,
        DetailContractEntity::class,
        DetailElectricEntity::class,
        DetailWaterEntity::class,
        EmployeeEntity::class,
        FamilyEntity::class,
        InvoiceBusinessEntity::class,
        InvoiceElectricEntity::class,
        InvoiceWaterEntity::class,
        RegionEntity::class
    ], version = VERSION_DATABASE, exportSchema = false
)

abstract class DatabaseLocal : RoomDatabase() {

    abstract fun getApartmentDao(): ApartmentDao
    abstract fun getBusinessDao(): BusinessDao
    abstract fun getContractDao(): ContractDao
    abstract fun getAccountDao(): AccountDao
    abstract fun getDetailBusinessDaoDao(): DetailBusinessDao
    abstract fun getDetailContractDao(): DetailContractDao
    abstract fun getDetailWaterDao(): DetailWaterDao
    abstract fun getDetailElectricDao(): DetailElectricDao
    abstract fun getInvoiceBusinessDao(): InvoiceBusinessDao
    abstract fun getInvoiceElectricDao(): InvoiceElectricDao
    abstract fun getInvoiceWaterDao(): InvoiceWaterDao
    abstract fun getEmployeeDao(): EmployeeDao
    abstract fun getFamilyDao(): FamilyDao
    abstract fun getRegionDao(): RegionDao


    companion object {
        private const val NAME_DATABASE = "ApartmentDatabase"
        const val VERSION_DATABASE = 1

        // Singleton prevents multiple instances of database opening at the
        @Volatile
        private var INSTANCE: DatabaseLocal? = null

        fun getDatabase(context: Context): DatabaseLocal {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseLocal::class.java,
                    NAME_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
