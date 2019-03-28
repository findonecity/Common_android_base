package com.example.baselib.base.base

/**
 * Created by zj on 2019/3/22.
 * is use for: v层基层
 */
interface IBaseView {
    //单事件提交时，展示dialog，无空白页等界面
    fun showLoading()

    //结束操作loading
    fun closeLoading()

    //加载整页界面数据时选用
    fun startLoading()

    //关闭加载，并可根据情况展示空白页等
    fun finishLoading()
}