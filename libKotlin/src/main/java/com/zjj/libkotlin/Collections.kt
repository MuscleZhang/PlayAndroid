package com.zjj.libkotlin


/**
 * 集合
 *
 * @author zhangjiajun
 * @since 2024/6/23
 */
class Collections {

    /**
     * 创建集合
     *
     * 创建不可变集合， listOf(), setOf(), mapOf()
     *
     * 使用listOf(), 创建空list时， 需要声明list中的类型
     * 使用emptyList, 创建空list
     *
     * 创建可变集合， mutableListOf(), mutableSetOf(), mutableMapOf()
     *
     */
    fun createCollections() {
        var list1 = listOf(1,2)
        var emptyList = emptyList<Int>()
        var set1 = setOf(1,2)
        var emptySet = emptySet<Int>()
        var map = mapOf(1 to "one", 2 to "two")
        var emptyMap = emptyMap<Int, String>()

        // 创建可变集合
        var list2 = mutableListOf(3,4)
        list2.add(3)
    }

    /**
     * 遍历集合
     *
     * 使用forEach 遍历
     *
     * list， set还可以通过forEachIndexed 遍历
     */

    fun test() {
        var list = listOf(1,2,3,4,5)
       list.forEachIndexed { index, i -> println("index: $index, i: $i") }
    }

    /**
     * 映射函数
     *
     * map: 转换每一个集合中的元素，根据map转换规则， 返回一个新的集合,
     * 可以一个元素转换成集合
     *
     * flatten(): 将嵌套的list结构"平铺", 转换成1维数组,
     *  flatten() 只能将list减少一级结构， 如3维数组flatten()之后， 变成2维数组， 且展开的是最外边的list结构
     *
     *
     *  flatMap() : 相当于map()和flatten() 符合函数
     */

    fun mapList() {
        var list = listOf(1,2,3,4)
        var map = mapOf(1 to "one", 2 to "two")
        var mapReturn = map.map {
//             println("" + it.key + " is " + it.value)
            "" + it.key + " is " + it.value
//            return "" + it.key + " is " + it.value
        }
        println("map" + mapReturn)
        println("list:" + list.map {
            it * it
        })

        var list1 = list.map { listOf(it  + 1, it + 2).map { it2 ->listOf(it2  + 1, it2 + 2) }}
        println("元素转换成集合： " +list1 )

        println("将多维list平铺： " + list1.flatten())

        println("flatmap():" + list.flatMap { listOf(it + 1, it + 2) })




    }
    /**
     * 过滤函数 filter()
     * 根据传入的筛选条件，对list进行筛选， 返回最终符合条件的元素集合
     *
     * filterIndexed()
     * 根据index和条件一起进行筛选
     */
    fun filterArr() {
        var list = listOf(Student("Andy", 13,70),
            Student("Bird", 23,90),Student("Carry", 17,100),Student("Demon", 30,50))
        println(list.filter { it.age > 20 })
    }

    data class Student(var name: String, var age: Int, var score: Int) {
        override fun toString(): String {
            return "Student(name: $name, age: $age, score:$score)"
        }
    }

    /**
     *
     *
     * 集合倒序 - 支持list, set
     * reversed() 底层实现是直接通过实现java的reverse()
     *
     * 升序排序 - 支持list, set
     * sorted() 底层实现是通过实现java的 sort()
     *
     * 元素去重
     * distinct()
     *
     * 其他相关集合方法查看
     * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/
     *
     */
}