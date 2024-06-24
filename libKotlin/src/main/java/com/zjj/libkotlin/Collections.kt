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
}