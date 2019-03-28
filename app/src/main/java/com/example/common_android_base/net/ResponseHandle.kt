package com.example.common_android_base.net

import android.app.Activity
import android.os.Handler
import com.example.baselib.base.base.Constant.HINT_FAIL
import com.example.baselib.base.base.Constant.HINT_SUCCESS
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * Created by zj on 2019/3/25.
 * is use for: 处理返回数据的success及提示等信息
 */
class ResponseHandle {
    companion object {
        fun <T> handleResponse(t:BaseResponse<T>,context:Activity): Boolean {
            return if (t.status == "success"){
                if (t.message != ""){
                    showHintDialog(t.message, HINT_SUCCESS,context)
                }
                true
            }else{
                showHintDialog(t.message, HINT_FAIL,context)
                false
            }
        }

        private var tipDialog: QMUITipDialog? = null
        private fun showHintDialog(message:String, messageType:Int,context: Activity) {
            try {
                when (messageType) {
                    HINT_SUCCESS -> {
                        tipDialog = QMUITipDialog.Builder(context)
                            .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                            .setTipWord(message)
                            .create()

                        tipDialog?.setCanceledOnTouchOutside(true)
                        tipDialog?.show()

                        Handler().postDelayed({
                            tipDialog?.cancel()
                        }, 1000)
                    }

                    HINT_FAIL -> {
                        tipDialog = QMUITipDialog.Builder(context)
                            .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                            .setTipWord(message)
                            .create()

                        tipDialog?.setCanceledOnTouchOutside(true)
                        tipDialog?.show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
