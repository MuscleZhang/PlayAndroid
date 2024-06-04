package com.zjj.libkotlin


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/3/20
 */
object Return {
    /**
     * 函数字面量
     */
    // 使用表达式声明了sum() 函数
    fun sum(a: Int, b: Int) = a + b

    // 使用fun 关键字声明了一个匿名函数， 并直接使用表达式来实现函数
    // sum的类型是： (kotlin.Int, kotlin.Int) -> kotlin.Int
    // >>> sumVal
    // (kotlin.Int, kotlin.Int) -> kotlin.Int
    // >>> sumVal(1,1)
    // 2
    val sumVal = fun(a: Int, b: Int) = a + b

    // 直接使用表达式声明函数
    // >>> sumF
    // (kotlin.Int, kotlin.Int) -> () -> kotlin.Int
    // >>> sumF(1,2)
    // () -> kotlin.Int
    // >>> sumF(1,2).invoke()  或 sumF(1,2)()
    // 3
    val sumF = fun(a: Int, b:Int) = { a + b }

    // >>> sumF2(1,2)
    // () -> kotlin.Int
    // >>> sumF2(1,2).invoke()
    // 3
    fun sumF2(a: Int, b: Int) = { a + b}

    /**
     * 1. kotlin中return语句会从最近的函数或匿名函数中返回
     * 2. 在Lambda表达式中遇到return语句时， 会直接返回最近的外部函数
     */
    val intArray = intArrayOf(1,2,3,4,5)

    fun testIntArray() {
        // lambda中 直接返回最近的函数
        // 输出1， 2
        intArray.forEach {
            if(it == 3) return
            println(it)
        }

        // 匿名函数中返回最近的函数， 即匿名函数， 不会跳出forEach循环
        // 输出1，2，4，5
        intArray.forEach { fun (a: Int) { // 这是匿名函数
            if(it == 3) return
            println(it)
        } }
    }

    /**
     * label 标签
     * kotlin中任意表达式都可以使用标签标记
     * 控制return，break, continue语句额跳转行为
     *
     * 隐形标签： 与接收lambda的函数同名
     *
     * 格式 _abc@
     */
    fun testLabel() {
        intArray.forEach here@ {
            // 返回到forEach 继续it == 4的循环
            if (it == 3) return@here

            println(it)
        }

        // 隐形标签
        intArray.forEach {
            if (it == 3) return@forEach
            println(it)
        }
    }

    /**
     *  throw表达式
     *  Nothing
     *
     *  kotlin中throw是表达式， 类型是Nothing， 该类型没有值
     *
     *  throw表达式赋值给变量时， 需要显式声明类型为Nothing
     *
     *      :: 是类引用操作符
     *  >> Nothing::class
     *  class java.lang.Void // Nothing直接映射到java中的Void类型
     */

    // ex没有任何值， 所以无法作为参数传给函数
    val ex: Nothing = throw Exception("Ex")





}