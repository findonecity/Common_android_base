package com.example.common_android_base.main

import android.app.Activity
import com.example.baselib.base.base.BasePresenter
import com.example.common_android_base.net.ResponseHandle
import com.example.common_android_base.net.exception.ExceptionHandle

/**
 * Created by zj on 2019/3/22.
 * is use for:
 */
class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter{
    override fun login(userName: String, password: String) {
        checkViewAttached()
        mView?.apply {
            startLoading()
        }
        addSubscription(disposable = mainModel.login(userName,password)
            .subscribe({
                mView?.apply {
                    finishLoading()
                    if (ResponseHandle.handleResponse(it,mView as Activity)){
                        showLoginBean(it.data)
                    }
                }
            },{
                mView?.apply {
                    finishLoading()
                    showError(ExceptionHandle.handleException(it),ExceptionHandle.errorCode)
                }
            }))
    }

    override fun getTestMessage() {
        checkViewAttached()
        mView?.apply {
            startLoading()
        }
        addSubscription(disposable = mainModel.getTestMessage()
            .subscribe({
                mView?.apply {
                    finishLoading()
                    mView?.setName(it[0])
                }
            },{
                mView?.apply {
                    finishLoading()
                    showError(ExceptionHandle.handleException(it),ExceptionHandle.errorCode)
                }
            }))
    }

    private val mainModel by lazy { MainModel() }

}