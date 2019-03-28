package com.example.common_android_base.net

import com.example.common_android_base.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by zj on 2019/3/23.
 * is use for: api请求管理器
 */
interface ApiService {
    @GET("v3/queries/hot")
    fun getHotWord(): Observable<ArrayList<String>>

    @POST("admin/AdminLogin.action")
    @FormUrlEncoded
    fun login(
        @Field("login_name") loginName: String,
        @Field("password") password: String): Observable<BaseResponse<LoginBean>>
}