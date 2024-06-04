package com.zjj.playandroid.widget

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.*
import com.zjj.playandroid.R
import com.zjj.playandroid.databinding.DialogBaseBinding


/**
 * 通用dialog
 *
 * @author zhangjiajun
 * @since 2024/3/12
 */
class CommonDialog(context: Context?, themeResId: Int) : Dialog(context!!, themeResId) {

    class Builder(private val context: Activity) {
        private var contentView: View? = null
        private var leftBtnText: String = "left"
        private var rightBtnText: String = "right"
        private var leftClickListener: View.OnClickListener? = null
        private var rightClickListener: View.OnClickListener? = null
        fun setContentView(contentView: View): Builder {
            this.contentView = contentView
            return this
        }
        fun setLeftBtnText(text: String): Builder {
            leftBtnText = text
            return this
        }
        fun setRightBtnText(text: String): Builder {
            rightBtnText = text
            return this
        }
        fun setLeftClickListener(listener: View.OnClickListener): Builder {
            leftClickListener = listener
            return this
        }
        fun setRightClickListener(listener: View.OnClickListener): Builder {
            rightClickListener = listener
            return this
        }

        var binding = DialogBaseBinding.inflate(context.layoutInflater)
        fun create(): CommonDialog {
            val dialog = CommonDialog(context, R.style.base_dialog)
            dialog.setContentView(
                binding.root, ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            contentView?.let {
                binding.container.addView(contentView)  }

            binding.leftBtn.text = leftBtnText
            binding.rightBtn.text = rightBtnText
            leftClickListener?.let {
                binding.leftBtn.setOnClickListener(leftClickListener)
            }
//            rightClickListener?.let {
//                binding.rightBtn.setOnClickListener(rightClickListener)
//            }
            binding.rightBtn.setOnClickListener {
                dialog.dismiss()
            }

            val window = dialog.window
            val windowManager = context.windowManager

            val defaultDisplay = windowManager.defaultDisplay

            val attributes = window!!.attributes
            attributes.gravity = Gravity.CENTER
            attributes.width = (defaultDisplay.width * 0.77).toInt()
//            attributes.height = (defaultDisplay.height * 0.5).toInt()
            window.attributes = attributes
            window.attributes.flags.toString()
//            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)


            return dialog
        }
    }
}