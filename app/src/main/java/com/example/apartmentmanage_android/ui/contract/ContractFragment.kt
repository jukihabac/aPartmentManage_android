package com.example.apartmentmanage_android.ui.contract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apartmentmanage_android.R
import com.example.apartmentmanage_android.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_contract.*
import javax.inject.Inject

class ContractFragment : BaseFragment(), ContractContract.View {

    @Inject
    lateinit var mPresenter: ContractContract.Presenter

    @Inject
    lateinit var mNavigator: ContractNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contract, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
    }

    override fun onSuccess() {
    }

    override fun onError(error: String) {
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
