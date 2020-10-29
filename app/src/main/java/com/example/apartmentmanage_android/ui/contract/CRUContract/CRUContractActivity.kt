package com.example.apartmentmanage_android.ui.contract.CRUContract

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_crucontract.*

class CRUContractActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crucontract)
        initViews()
        initData()
        handleEvents()
    }

    private fun handleEvents() {
        saveButton.setOnClickListener {
            if (intent.getIntExtra("REQUEST_ADD", Constants.NOT_EXISTS) == 1) {
                intent.putExtra(
                    RESPONSE_ADD,
                    ContractEntity(
                        contractIDEditText.text.toString(),
                        contractNameEditText.text.toString(), "", "", "", "", 0f
                    )
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (intent.getIntExtra("REQUEST_UPDATE", Constants.NOT_EXISTS) == 2) {
                intent.putExtra(RESPONSE_UPDATE, "DU LIEU UPDATE")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        previousButton.setOnClickListener {
            finish()
        }
    }

    private fun initData() {
        //no-op
    }

    private fun initViews() {
        initContractKindDropDown()
        //no-op
    }

    private fun initContractKindDropDown() {
        val items = listOf("Thuê", "Mua")
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu, items)
        contractKindDropDown?.setAdapter(adapter)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right)
    }

    companion object {
        const val RESPONSE_ADD = "RESPONSE_ADD"
        const val RESPONSE_UPDATE = "RESPONSE_UPDATE"
    }

}
