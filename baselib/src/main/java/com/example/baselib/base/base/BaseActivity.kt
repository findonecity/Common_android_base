package com.example.baselib.base.base

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.classic.common.MultipleStatusView
import com.example.baselib.base.base.Constant.HINT_FAIL
import com.example.baselib.base.base.Constant.HINT_SUCCESS
import com.example.baselib.base.progress.ProgressDialogHandler
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * Created by zj on 2019/3/22.
 * is use for: activity基类
 */
abstract class BaseActivity :AppCompatActivity(){
    protected var mLayoutStatusView: MultipleStatusView? = null
    var loadDialog: ProgressDialogHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        initData()
        initView()

        loadDialog = ProgressDialogHandler(this, null, true)

        startRequest()
        initRetryListener()
    }

    //错误布局重新加载数据
    private fun initRetryListener() {
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        startRequest()
    }

    /**
     *  加载布局
     */
    abstract fun layoutId(): Int
    /**
     * 初始化数据
     */
    abstract fun initData()
    /**
     * 初始化 View
     */
    abstract fun initView()
    /**
     * 请求数据
     */
    abstract fun startRequest()

    /**
     * 导航栏 自定义是否添加
     */

    /**
     * 单事件提交时，展示dialog，无空白页等界面
     */
    fun showLoading() {
        loadDialog?.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG)?.sendToTarget()
    }

    /**
     * 关闭loading提示框
     */
    fun closeLoading() {
        loadDialog?.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG)?.sendToTarget()
        loadDialog = null
    }

    private var tipDialog: QMUITipDialog? = null
    private fun showHintDialog(message:String, messageType:Int){
        try {
            when(messageType){
                HINT_SUCCESS ->{
                    tipDialog = QMUITipDialog.Builder(this)
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                        .setTipWord(message)
                        .create()

                    tipDialog?.setCanceledOnTouchOutside(true)
                    tipDialog?.show()

                    Handler().postDelayed({
                        tipDialog?.cancel()
                    }, 1000)
                }

                HINT_FAIL ->{
                    tipDialog = QMUITipDialog.Builder(this)
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                        .setTipWord(message)
                        .create()

                    tipDialog?.setCanceledOnTouchOutside(true)
                    tipDialog?.show()
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}