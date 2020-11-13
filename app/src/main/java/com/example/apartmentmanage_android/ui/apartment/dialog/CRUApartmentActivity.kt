package com.example.apartmentmanage_android.ui.apartment.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
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
        intent?.extras?.getParcelable<ApartmentEntity>(APARTMENT_EXTRA).let {
            if (it != null) {
                apartmentIDEditText.setText(it.ID.toString())
                apartmentIDEditText.isEnabled = false
                apartmentNameEditText.setText(it.name)
                kind_dropdown.setText(it.kind)
                costEditText.setText(it.cost.toString())
                statesEditText.setText(it.state)
                noteEditText.setText(it.note)
                regionID_dropdown.setText(it.regionID)
                familyID_dropdown.setText(it.familyID)
            }
        }
    }

    private fun handleEvents() {
        previousButton.setOnClickListener {
            finish()
        }
        submitButton.setOnClickListener {
            if (intent.getIntExtra("REQUEST_ADD", Constants.NOT_EXISTS) == 1) {
                putExtraApartment(Constants.RESPONSE_ADD)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (intent.getIntExtra("REQUEST_UPDATE", Constants.NOT_EXISTS) == 2) {
                putExtraApartment(Constants.RESPONSE_UPDATE)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun putExtraApartment(RESPONSE: String) {
        intent.putExtra(
            RESPONSE,
            ApartmentEntity(
                apartmentIDEditText.text.toString(),
                apartmentNameEditText.text.toString(),
                kind_dropdown.text.toString(),
                costEditText.text.toString().toFloat(),
                statesEditText.text.toString(),
                noteEditText.text.toString(),
                regionID_dropdown.text.toString(),
                familyID_dropdown.text.toString()
            )
        )
    }

    companion object {
        val TAG = CRUApartmentActivity::class.java.simpleName
        const val APARTMENT_EXTRA = "APARTMENT_EXTRA"

        fun newInstance(context: Context?, apartmentEntity: ApartmentEntity): Intent {
            return Intent(context, CRUApartmentActivity::class.java).apply {
                putExtra("REQUEST_UPDATE", Constants.REQUEST_UPDATE)
                putExtra(APARTMENT_EXTRA, apartmentEntity)
            }
        }

        fun newInstance(context: Context?): Intent {
            return Intent(context, CRUApartmentActivity::class.java).apply {
                putExtra("REQUEST_ADD", Constants.REQUEST_ADD)
            }
        }
    }
}
