package com.zjj.libkotlin


/**
 * 操作符
 *
 * @author zhangjiajun
 * @since 2024/3/21
 */
object Operation {
    /**
     * 一元操作符
     */

    /**
     * 前缀操作符
     * +a: a.unaryPlus()
     * -a: a.unaryMinus()
     * !a: a.not()
     */
    data class Point(val x: Int, val y: Int)
    // 重载操作符 需要使用operator 标记， 中缀操作符函数使用infix 标记
    operator fun Point.unaryMinus() = Point(-x, y - 3)

    fun pointUnaryMinus() {
        val p = Point(1, 5)
        println(-p)
    }
    /**
     * 二元操作符
     *
     * 字符串的"+"重载
     * "" + 1 ： 1 (String类型)  使用的字符串的"+"重载
     * 1 + "" ： 报错 找不到方法 使用的是Int的"+"重载
     *
     * in操作符
     * a in b : b.contains(a)
     * a !in b:  !b.contains(a)
     *
     * 索引访问操作符
     * a[i] : a.get(i)
     * a[i] = b = a.set(i, b)
     *
     * === 和!== 不能被重载
     *
     * Elvis操作符 ?:
     * y=x?:0  表示 y = if(x !== null) x else 0
     *
     */

    // 自定义 "+"重载
    data class Counter(val index: Int)

    operator fun Counter.plus(increment: Int) : Counter {
        return Counter(index + increment)
    }

    /**
     * 中缀表达式 infix
     */
    data class Person(val name: String, val age: Int)

    infix fun Person.grow(years: Int):Person {
        return Person(name, age + years)
    }

}