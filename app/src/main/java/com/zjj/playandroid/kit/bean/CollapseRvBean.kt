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
    val childList = mutableListOf<CollapseRvBean>()
    var depth: Int = 1
    var isExpanded:Boolean = false

    constructor(name: String, depth: Int, isExpanded: Boolean = false, onClick: View.OnClickListener? = null, childList: MutableCollection<CollapseRvBean>) : this(name) {
        this.onClick = onClick
        childList.let { it -> it.also { this.childList.addAll(it) } }
        this.depth = depth
        this.isExpanded = isExpanded
    }

    fun addChild(childName: String, onClick: View.OnClickListener) {
        var child = CollapseRvBean(childName)
        child.depth = depth + 1
        child.onClick = onClick
        childList.add(child)
    }

}