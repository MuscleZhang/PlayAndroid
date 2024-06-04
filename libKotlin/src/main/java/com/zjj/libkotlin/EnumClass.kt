package com.zjj.libkotlin


/**
 * 枚举
 *
 * @author zhangjiajun
 * @since 2024/5/14
 */
class EnumClass {

    /**
     * 枚举类 使用 enum class 表示
     * 内置了两个属性
     *  name: EAST
     *  ordinal: 0
     */
    enum class Direction {
        EAST,SOUTH,WEST,NORTH
    }

    enum class Color(val rgb: Int) {
        GREEN(0x00FF00),
        RED(0xFF0000)
    }
}