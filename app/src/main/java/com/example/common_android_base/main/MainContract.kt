package com.example.common_android_base.main

import com.example.baselib.base.base.IBaseView
import com.example.baselib.base.base.IPresenter
import com.example.common_android_base.bean.LoginBean

/**
 * Created by zj on 2019/3/22.
 * is use for:
 */
interface MainContract {
    interface View: IBaseView {
        fun showError(errorMsg:String,errorCode:Int)
        fun setName(name:String)
        fun showLoginBean(bean:LoginBean)
    }

    interface Presenter: IPresenter<View> {
        fun getTestMessage()
        fun login(userName:String,password:String)
    }
}