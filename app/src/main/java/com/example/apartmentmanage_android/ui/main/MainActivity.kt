package com.example.apartmentmanage_android.ui.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var mPresenter: MainContract.Presenter

    @Inject
    lateinit var mAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onStart() {
        mPresenter.onStart()
        super.onStart()
    }

    override fun onStop() {
        mPresenter.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    private fun initViews() {
        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            for (i in 0 until bottomNavigationView.menu.size()) {
                if (bottomNavigationView.menu.getItem(i).itemId == it.itemId) {
                    mainViewPager.currentItem = i
                }
            }
            true
        }
    }

    private fun setupViewPager() {
        mainViewPager.adapter = mAdapter
        mainViewPager.offscreenPageLimit = OFF_SCREEN_PAGE_LIMIT
        mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                val itemID = bottomNavigationView.menu.getItem(position).itemId
                bottomNavigationView.selectedItemId = itemID
            }
        })
    }

    companion object {
        const val OFF_SCREEN_PAGE_LIMIT = 5
    }
}
