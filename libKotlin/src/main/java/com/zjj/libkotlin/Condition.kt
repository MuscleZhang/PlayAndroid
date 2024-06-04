package com.zjj.libkotlin


/**
 * 流程控制语句 if when
 *
 * @author zhangjiajun
 * @since 2024/3/15
 */
object Condition {
    /**
     * when 实现阶乘
     *
     */
    fun fact (n: Long): Long {
        return when (n) {
            0L, 1L -> {
                n
            }
            else -> {
                n * fact(n - 1)
            }
        }
    }
    /**
     * for 通过索引遍历数组
     */
    fun ergodicByIndex() {
        val array = arrayOf(1,2,3,4,5,6)
        // 方法1
//        for (i in array.indices) {
//            print(i)
//        }
        // 方法2
//        array.forEachIndexed {
//            index, i ->
//            println("$index  $i")
//        }
        for ((index, i) in array.withIndex()) {
            print("$index  $i ,")
        }
    }

    /**
     * 输出1！+2！+3！+…+10！的和。
     */
    fun sumFact() : Long {
        var sum = 0L
        for (i in 1..10) {
            sum += fact(i.toLong())
        }
        return sum
    }
}