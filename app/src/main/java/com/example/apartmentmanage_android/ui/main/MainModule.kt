package com.example.testquestion.ui.main

import com.example.apartmentmanage_android.ui.main.MainActivity
import com.example.apartmentmanage_android.ui.main.MainContract
import com.example.apartmentmanage_android.ui.main.MainPagerAdapter
import com.example.apartmentmanage_android.ui.main.MainPresenter
import com.example.apartmentmanage_android.di.scopes.ActivityScoped
import com.example.apartmentmanage_android.ui.apartment.ApartmentFragment
import com.example.apartmentmanage_android.ui.business.BusinessFragment
import com.example.apartmentmanage_android.ui.contract.ContractFragment
import com.example.apartmentmanage_android.ui.family.FamilyFragment
import com.example.apartmentmanage_android.ui.utility.UtilityFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MainModule.MainAbstractModule::class])
class MainModule {

    @ActivityScoped
    @Provides
    fun bindMainViewPager(mainActivity: MainActivity): MainPagerAdapter {
        val adapter = MainPagerAdapter(mainActivity.supportFragmentManager)
        adapter.addFragment(ApartmentFragment.newInstance())
        adapter.addFragment(ContractFragment.newInstance())
        adapter.addFragment(BusinessFragment.newInstance())
        adapter.addFragment(UtilityFragment.newInstance())
        return adapter
    }

    @Module
    interface MainAbstractModule {
        @ActivityScoped
        @Binds
        fun bindMainView(mainActivity: MainActivity): MainContract.View

        @ActivityScoped
        @Binds
        fun bindMainPresenter(presenter: MainPresenter): MainContract.Presenter
    }
}
