package com.example.common_android_base.main

import com.example.baselib.base.base.BaseActivity
import com.example.common_android_base.R
import com.example.common_android_base.bean.LoginBean
import com.example.common_android_base.net.exception.ErrorStatus
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainContract.View {
    override fun showLoginBean(bean: LoginBean) {
        tvName.text = bean.login_name

        tvName.setOnClickListener {

        }
    }

    override fun setName(name: String) {
        tvName.text = name

        tvName.setOnClickListener {
            showLoading()
        }
    }

    override fun showError(errorMsg: String, errorCode: Int) {
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView?.showNoNetwork()
        } else {
            mLayoutStatusView?.showError()
        }
    }

    private val mPresenter by lazy { MainPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun startLoading() {
        mLayoutStatusView?.showLoading()
    }

    override fun finishLoading() {
        mLayoutStatusView?.showContent()
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView
    }

    override fun startRequest() {
//        mPresenter.getTestMessage()
        mPresenter.login("zj","123456")
    }

}
