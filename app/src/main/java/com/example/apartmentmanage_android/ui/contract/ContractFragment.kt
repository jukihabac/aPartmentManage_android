package com.example.apartmentmanage_android.ui.contract

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.app.Constants
import com.example.apartmentmanage_android.data.source.local.roompersistence.entity.ContractEntity
import com.example.apartmentmanage_android.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_contract.*
import javax.inject.Inject

class ContractFragment : BaseFragment(), ContractContract.View, ContractAdapter.OnActionListener {

    @Inject
    lateinit var mPresenter: ContractContract.Presenter

    @Inject
    lateinit var mNavigator: ContractNavigator

    @Inject
    lateinit var mAdapter: ContractAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contract, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setUpData()
        handleEvents()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.REQUEST_ADD) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                mPresenter.addContract(data.getParcelableExtra(Constants.RESPONSE_ADD))
            }
        } else if (requestCode == Constants.REQUEST_UPDATE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                mPresenter.updateContract(data.getParcelableExtra(Constants.RESPONSE_UPDATE))
            }
        }
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

    override fun onSuccessGetContracts(contracts: List<ContractEntity>) {
        mAdapter.addContracts(contracts)
    }

    override fun onSuccessAddContract(contractEntity: ContractEntity) {
        mAdapter.addContract(contractEntity)
    }

    override fun onSuccessDeleteContract(contractID: String) {
        mAdapter.removeContract(contractID)
    }

    override fun onSuccessUpdateContract(contractEntity: ContractEntity) {
        mAdapter.updateContract(contractEntity)
    }

    override fun onError(error: String) {
    }

    override fun onEditListener(contractEntity: ContractEntity) {
        mNavigator.navigateToUpdateContract(contractEntity)
    }

    override fun onDeleteListener(contractID: String) {
        mPresenter.deleteContract(contractID)
    }

    private fun setupViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter.setOnActionListener(this)
        contractRecyclerView.adapter = mAdapter
        contractRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpData() {
        mPresenter.getContracts()
    }

    private fun handleEvents() {
        contractFloatButton.setOnClickListener {
            mNavigator.navigateToAddContract()
        }
    }

    companion object {
        fun newInstance() = ContractFragment()
    }
}
