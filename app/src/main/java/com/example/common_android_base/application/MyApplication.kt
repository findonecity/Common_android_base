package com.example.common_android_base.application

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by zj on 2019/3/22.
 * is use for: application
 */
class MyApplication : MultiDexApplication() {
    //单例
    var SCREEN_WIDTH = -1
    var SCREEN_HEIGHT = -1
    var DIMEN_RATE = -1.0f
    var DIMEN_DPI = -1
    companion object {
        var instanceTmp: MyApplication? = null
        fun getInstance(): MyApplication? {
            if (instanceTmp == null) {
                instanceTmp = MyApplication()
            }
            return instanceTmp
        }
    }

    override fun onCreate() {
        super.onCreate()
        instanceTmp = this

        getScreenSize()

        //出现异常时调用提示用户系统崩溃
//        CrashHandler.getInstance().init(applicationContext)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        MultiDex.install(this)
    }

    //初始化屏幕宽高
    private fun getScreenSize() {
        val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        val display = windowManager.defaultDisplay
        display.getMetrics(dm)
        DIMEN_RATE = dm.density / 1.0f
        DIMEN_DPI = dm.densityDpi
        SCREEN_WIDTH = dm.widthPixels
        SCREEN_HEIGHT = dm.heightPixels
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            val t = SCREEN_HEIGHT
            SCREEN_HEIGHT = SCREEN_WIDTH
            SCREEN_WIDTH = t
        }
    }
}