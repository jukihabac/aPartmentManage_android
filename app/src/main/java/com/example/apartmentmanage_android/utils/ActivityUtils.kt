package com.example.apartmentmanage_android.utils

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.apartmentmanage_android.R

object ActivityUtils {

    inline fun <reified T : AppCompatActivity> startWithSlideAnimation(
        context: Context?
    ) {
        val intent = Intent(context, T::class.java)
        context?.startActivity(
            intent,
            ActivityOptions.makeCustomAnimation(
                context,
                R.anim.enter_from_right,
                R.anim.exit_to_left
            ).toBundle()
        )
    }

    inline fun <reified T : AppCompatActivity> startWithFadeAnimation(
        context: Context?
    ) {
        val intent = Intent(context, T::class.java)
        context?.startActivity(
            intent,
            ActivityOptions.makeCustomAnimation(
                context,
                R.anim.fade_in,
                R.anim.fade_out
            ).toBundle()
        )
    }

    fun startWithBundleSlideAnimation(
        context: Context?, intent: Intent?
    ) {
        context?.startActivity(
            intent,
            ActivityOptions.makeCustomAnimation(
                context,
                R.anim.enter_from_right,
                R.anim.exit_to_left
            ).toBundle()
        )
    }

    fun startWithBundleSlideStackAnimation(
        context: Context?, intent: Intent?
    ) {
        context?.startActivity(
            intent,
            ActivityOptions.makeCustomAnimation(
                context,
                R.anim.enter_from_right,
                R.anim.exit_near_to_left
            ).toBundle()
        )
    }

    fun startActivityForResultSlideByFragment(
        fragment: Fragment,
        context: Context?, intent: Intent?, requestCode: Int
    ) {
        fragment.startActivityForResult(
            intent, requestCode,
            ActivityOptions.makeCustomAnimation(
                context,
                R.anim.enter_from_right,
                R.anim.exit_near_to_left
            ).toBundle()
        )
    }
}
