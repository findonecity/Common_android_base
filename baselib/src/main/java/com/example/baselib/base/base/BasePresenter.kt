package com.example.baselib.base.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by zj on 2019/3/23.
 * is use for: base p层
 */
open class BasePresenter<T : IBaseView> : IPresenter<T> {

    var mView: T? = null
        private set

    private var compositeDisposable = CompositeDisposable()


    override fun attachView(mView: T) {
        this.mView = mView
    }

    override fun detachView() {
        mView = null

         //保证activity结束时取消所有正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }

    }

    private val isViewAttached: Boolean
        get() = mView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")


}