package com.example.apartmentmanage_android.ui.apartment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_apartment.*
import javax.inject.Inject

class ApartmentFragment : BaseFragment(), ApartmentContract.View {

    @Inject
    lateinit var mPresenter: ApartmentContract.Presenter

    @Inject
    lateinit var mAdapter: ApartmentAdapter

    @Inject
    lateinit var mNavigator: ApartmentNavigator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_apartment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupData()
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

    override fun onSuccessGetApartment(apartments: List<ApartmentEntity>) {
        mAdapter.addApartment(apartments)
    }

    override fun onSuccess() {
        //no-op
    }

    override fun onError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_ADD) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                mPresenter.addApartment(data.getParcelableExtra(Constants.RESPONSE_ADD))
            }
        } else if (requestCode == Constants.REQUEST_UPDATE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                //  mPresenter.updateContract(data.getParcelableExtra(Constants.RESPONSE_UPDATE))
            }
        }
    }

    private fun setupData() {
        mPresenter.getApartments()
    }

    private fun setupViews() {
        setupRecyclerView()
        setupFloatButton()
    }

    private fun setupFloatButton() {
        apartmentFloatButton.setOnClickListener {
            mNavigator.navigateToAddApartment()
        }
    }

    private fun setupRecyclerView() {
        apartmentRecyclerView.adapter = mAdapter
        apartmentRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    companion object {
        fun newInstance() = ApartmentFragment()
    }
}
