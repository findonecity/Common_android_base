package com.example.common_android_base.net

/**
 * Created by zj on 2019/3/25.
 * is use for: base返回
 */
class BaseResponse<T>(val status_code :Int,
                      val message:String,
                      val status:String,
                      val data:T)