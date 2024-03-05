package com.zjj.playandroid.utils


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/2/27
 */
object ListUtils {
    fun <E> isEmpty(list: List<E>): Boolean {
        return list == null || list.isEmpty()
    }
}