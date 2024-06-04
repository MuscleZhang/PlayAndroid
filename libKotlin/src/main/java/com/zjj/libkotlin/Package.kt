package com.zjj.libkotlin

// 包级函数
fun packageMethod() {

}

/**
 * 包
 *
 * @author zhangjiajun
 * @since 2024/3/22
 */
object Package {
    /**
     * 定义在包下的叫做 包级函数
     *
     * 一个包下只能有一个main()函数
     *
     * 同包下的不同文件中的代码可以直接使用
     *
     */

    /**
     * kotlin会默认倒入基础包
     *     kotlin.*
     *     kotlin.annotation.*
     *     kotlin.collections.*
     *     kotlin.comparisons.* （自1.1起）
     *     kotlin.io.*
     *     kotlin.ranges.*
     *     kotlin.sequences.*
     *     kotlin.text.*
     *
     * 在JVM平台会默认额外导入
     *     java.lang.*
     *     kotlin.jvm.*
     *
     * JS平台会默认额外导入
     *     kotlin.js.*
     */
}