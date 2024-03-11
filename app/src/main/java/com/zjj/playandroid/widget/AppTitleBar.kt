package com.zjj.playandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout


/**
 * 标题栏
 *
 * @author zhangjiajun
 * @since 2024/3/7
 */
class AppTitleBar: LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

}