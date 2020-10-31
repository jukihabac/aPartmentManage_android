package com.example.apartmentmanage_android.ui.apartment.dialog

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.RegionEntity
import com.example.apartmentmanage_android.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_cruapartment.*
import javax.inject.Inject

class CRUApartmentActivity : BaseActivity(), CRUApartmentContract.View {

    @Inject
    lateinit var mPresenter: CRUApartmentContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cruapartment)
        setupViews()
        setupData()
        handleEvents()
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

    override fun onSuccessRegionIDs(region: List<RegionEntity>) {
        val regionIDs = arrayOf(region.map { it.ID })
        val adapter = ArrayAdapter(
            this,
            R.layout.dropdown_menu,
            regionIDs
        )
        regionID_dropdown.setAdapter(adapter)
    }

    override fun onSuccessFamilyIDs(family: List<FamilyEntity>) {
        val familyIDs = arrayOf(family.map { it.ID })
        val adapter = ArrayAdapter(
            this,
            R.layout.dropdown_menu,
            familyIDs
        )
        familyID_dropdown.setAdapter(adapter)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right)
    }

    private fun setupData() {
        mPresenter.getFamilyIDs()
        mPresenter.getRegionIDs()
    }

    private fun setupViews() {
        //no-op
    }

    private fun handleEvents() {
        previousButton.setOnClickListener {
            finish()
        }
        submitButton.setOnClickListener {
            if (intent.getIntExtra("REQUEST_ADD", Constants.NOT_EXISTS) == 1) {
                intent.putExtra(
                    Constants.RESPONSE_ADD,
                    ApartmentEntity(
                        apartmentIDEditText.text.toString(),
                        apartmentNameEditText.text.toString(), "", 10f, "", "", "", ""
                    )
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (intent.getIntExtra("REQUEST_UPDATE", Constants.NOT_EXISTS) == 2) {
                intent.putExtra(Constants.RESPONSE_UPDATE, "DU LIEU UPDATE")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        val TAG = CRUApartmentActivity::class.java.simpleName
        fun newInstance() = CRUApartmentActivity()
    }
}
