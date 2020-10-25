package com.example.apartmentmanage_android.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.apartmentmanage_android.R

object FragmentManagerUtils {
    fun replaceFragment(
        fragmentManager: FragmentManager,
        layoutId: Int,
        fragment: Fragment?,
        isAddToBackStack: Boolean = false
    ) {
        val transaction =
            fragmentManager.beginTransaction()
        transaction.replace(layoutId, fragment!!)
        if (isAddToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun replaceFragmentWithFadeAnimation(
        fragmentManager: FragmentManager,
        layoutId: Int,
        fragment: Fragment?
    ) {
        val transaction =
            fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.fade_in,
            R.anim.fade_out
        )
        transaction.replace(layoutId, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun replaceFragmentWithSlideAnimation(
        fragmentManager: FragmentManager,
        layoutId: Int,
        fragment: Fragment?
    ) {
        val transaction =
            fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left
        )
        transaction.replace(layoutId, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
