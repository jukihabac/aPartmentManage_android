package com.example.apartmentmanage_android.data.source.local.roompersistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apartmentmanage_android.data.source.local.roompersistence.DatabaseLocal.Companion.VERSION_DATABASE
import com.example.apartmentmanage_android.data.source.local.roompersistence.dao.ApartmentDao
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.*
import com.example.apartmentmanage_android.di.scopes.AppScoped

@Database(entities = [
    AccountEntity::class ,
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
], version = VERSION_DATABASE, exportSchema = false)

abstract class DatabaseLocal : RoomDatabase() {

    abstract fun getApartmentDao(): ApartmentDao

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
