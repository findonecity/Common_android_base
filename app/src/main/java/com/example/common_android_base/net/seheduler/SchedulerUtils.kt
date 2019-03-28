package com.example.common_android_base.net.seheduler

/**
 * Created by zj on 2019/3/23.
 * is use for: 线程调度器
 */

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}
