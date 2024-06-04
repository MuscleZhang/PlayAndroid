package com.zjj.playandroid.kit.bean

import android.view.View


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/2/27
 */
data class CollapseRvBean(val name: String) {
    var onClick : View.OnClickListener? = null
    var childList : List<CollapseRvBean>? = null
    var depth: Int = 1
    var isExpanded:Boolean = false

    constructor(name: String, depth: Int, isExpanded: Boolean = false, onClick: View.OnClickListener? = null, childList: List<CollapseRvBean>? = null) : this(name) {
        this.onClick = onClick
        this.childList = childList
        this.depth = depth
        this.isExpanded = isExpanded
    }
//
//    fun buildBean (): CollapseRvBean {
//        val bean = CollapseRvBean(name)
//        return bean
//    }

}