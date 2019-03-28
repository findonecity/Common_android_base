package com.example.common_android_base.main

import com.example.common_android_base.bean.LoginBean
import com.example.common_android_base.net.BaseResponse
import com.example.common_android_base.net.RetrofitManager
import com.example.common_android_base.net.seheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by zj on 2019/3/22.
 * is use for:
 */
class MainModel {
    fun getTestMessage(): Observable<ArrayList<String>> {
        return RetrofitManager.apiService.getHotWord()
            .compose(SchedulerUtils.ioToMain())
    }


    fun login(loginName:String,password:String):Observable<BaseResponse<LoginBean>>{
        return RetrofitManager.apiService.login(loginName,password)
            .compose(SchedulerUtils.ioToMain())
    }
}