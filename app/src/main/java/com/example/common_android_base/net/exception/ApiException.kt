package com.example.common_android_base.net.exception

/**
 * Created by zj on 2019/3/23.
 * is use for: api异常
 */
class ApiException : RuntimeException {

    private var code: Int? = null


    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))
}