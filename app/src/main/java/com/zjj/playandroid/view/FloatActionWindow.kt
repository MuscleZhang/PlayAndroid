package com.zjj.playandroid.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zjj.playandroid.LogUtils
import com.zjj.playandroid.R


/**
 * 悬浮功能按钮
 *
 * @author zhangjiajun
 * @since 2023/11/1
 */
class FloatActionWindow : ViewGroup {
    val TAG = "FloatWindow"
    constructor(context: Context?): this(context, null) {
        init(context)
    }


    constructor(context: Context?, attrs: AttributeSet?): this(context, null, 0) {

    }
    constructor(context: Context?, attrs: AttributeSet?, def: Int): super(context, attrs, def) {

    }
    private fun init(context: Context?) {
        val view = LayoutInflater.from(context).inflate(R.layout.window_float, null)
        view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "onClick")
//                LogUtils.
            }
        })

    }
//
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }


}

