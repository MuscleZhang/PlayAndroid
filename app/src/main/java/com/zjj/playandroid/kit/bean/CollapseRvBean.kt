package com.zjj.playandroid.kit.bean

import android.view.View


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/2/27
 */
data class CollapseRvBean(
    val name: String,
    val onClick: View.OnClickListener,
    val childList: List<CollapseRvBean>,
    val depth: Int,
    var isExpanded: Boolean
) {


}