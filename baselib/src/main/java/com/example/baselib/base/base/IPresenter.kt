package com.example.baselib.base.base

/**
 * Created by zj on 2019/3/22.
 * is use for: p层基层
 */
interface IPresenter<in V: IBaseView> {
    fun attachView(mRootView: V)

    fun detachView()
}