package com.example.apartmentmanage_android.ui.contract.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ApartmentEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.EmployeeEntity
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.FamilyEntity
import com.example.apartmentmanage_android.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_crucontract.*
import kotlinx.android.synthetic.main.activity_crucontract.previousButton
import javax.inject.Inject

class CRUContractActivity : BaseActivity(), CRUContractContract.View {

    @Inject
    lateinit var mPresenter: CRUContractContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crucontract)
        initViews()
        initData()
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

    private fun handleEvents() {
        saveButton.setOnClickListener {
            if (intent.getIntExtra("REQUEST_ADD", Constants.NOT_EXISTS) == 1) {
                intent.putExtra(
                    Constants.RESPONSE_ADD,
                    getContractEntity()
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (intent.getIntExtra("REQUEST_UPDATE", Constants.NOT_EXISTS) == 2) {
                intent.putExtra(
                    Constants.RESPONSE_UPDATE,
                    getContractEntity()
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        previousButton.setOnClickListener {
            finish()
        }
    }

    private fun getContractEntity(): ContractEntity {
        return ContractEntity(
            contractIDEditText.text.toString(),
            contractNameEditText.text.toString(),
            contractKindDropDown.text.toString(),
            employeeIDDropDown.text.toString(),
            apartmentIDDropDown.text.toString(),
            familyIDDropDown.text.toString(),
            0f
        )
    }

    private fun initData() {
        initContractKindDropDown()
        mPresenter.getApartmentIDs()
        mPresenter.getEmployeeIDs()
        mPresenter.getFamilyIDs()
    }

    private fun initViews() {
        intent?.extras?.getParcelable<ContractEntity>(CONTRACT_EXTRA).let {
            if (it != null) {
                contractIDEditText.setText(it.ID)
                contractIDEditText.isEnabled = false
                contractNameEditText.setText(it.name)
                contractKindDropDown.setText(it.kind)
                employeeIDDropDown.setText(it.employeeID)
                apartmentIDDropDown.setText(it.apartmentID)
                familyIDDropDown.setText(it.familyID)
                sumCostTextView.setText(it.sum.toString())
            }
        }
    }

    private fun initContractKindDropDown() {
        val items = listOf(getString(R.string.Rent), getString(R.string.Buy))
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu, items)
        contractKindDropDown?.setAdapter(adapter)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right)
    }

    override fun onSuccessEmployeeIDs(employee: List<EmployeeEntity>) {
        val items = employee.map { it.ID }
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu, items)
        employeeIDDropDown?.setAdapter(adapter)
    }

    override fun onSuccessApartmentIDs(Apartment: List<ApartmentEntity>) {
        val items = Apartment.map { it.ID }
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu, items)
        apartmentIDDropDown.setAdapter(adapter)
    }

    override fun onSuccessFamilyIDs(family: List<FamilyEntity>) {
        val items = family.map { it.ID }
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu, items)
        familyIDDropDown.setAdapter(adapter)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val CONTRACT_EXTRA = "CONTRACT_EXTRA"

        fun newInstance(context: Context?): Intent {
            return Intent(context, CRUContractActivity::class.java).apply {
                putExtra("REQUEST_ADD", Constants.REQUEST_ADD)
            }
        }

        fun newInstance(context: Context?, contractEntity: ContractEntity): Intent {
            return Intent(context, CRUContractActivity::class.java).apply {
                putExtra("REQUEST_UPDATE", Constants.REQUEST_UPDATE)
                putExtra(CONTRACT_EXTRA, contractEntity)
            }
        }
    }
}
