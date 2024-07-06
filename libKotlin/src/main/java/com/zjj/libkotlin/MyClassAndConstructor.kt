package com.zjj.libkotlin


/**
 * 类 构造方法
 *
 * @author zhangjiajun
 * @since 2024/3/28
 */
object MyClassAndConstructor {
    /**
     * 主构造方法
     *
     * 声明类的同时声明的主构造方法
     *
     * lateinit  表示延迟初始化 不能修饰private
     */
    class Person(var name: String, var age: Int) {

        /**
         * 次级构造函数
         *
         * 必须继承this()
         */
        constructor(sex: String) : this("Dominic", 20) {

        }
    }

    /**
     * 下方类会自动创建构造方法
     */
    class Person2 {
        lateinit var name: String
        var age: Int = 0
        lateinit var sex: String
    }

    /**
     * 抽象类
     *
     * kotlin 中抽象类中的成员（没有初始化的属性和函数）也必须是抽象的 abstract修饰
     */

    abstract class Shape {
        abstract var width: Double
        abstract var height: Double
        var radius: Double = 10.0
        abstract fun area(): Double

        /**
         * 默认是final的， 无法覆盖重写， 如果想要重写 需要使用open标记
         */
        open fun onClick() {
            print("click shape")
        }
    }

    /**
     * 实现抽象类
     *
     * 声明实现类 同时也要声明构造方法
     */
    class Round(override var width: Double, override var height: Double) : Shape() {
        override fun area(): Double {
            return 3.14 * width / 2
        }

        override fun onClick() {
            print("${this::class.simpleName} is clicked")
        }

    }

    /**
     * 接口
     */
    interface ProjectService {
        var name: String
        var owner: String
        fun save()
        fun print() {
            print("ProjectService")
        }
    }

    interface ProjectService2 {

        fun print() {
            print("ProjectService2")
        }
    }

    /**
     * 实现接口
     */
    class ProjectImpl(override var name: String, override var owner: String) : ProjectService, ProjectService2 {
        override fun save() {
        }

        override fun print() {
            // 因为两个接口都有print, 会发生覆盖冲突
            // super.print()
            // 调用ProjectService.print()
            super<ProjectService>.print()
            // 调用ProjectService2.print()
            super<ProjectService2>.print()
        }
    }

    /**
     * 通过匿名内部类 实现接口
     */
    fun invokeImpl() {
        var a = object : ProjectService {
            override var name: String
                get() = "name"
                set(value) {}
            override var owner: String
                get() = "owner"
                set(value) {}

            override fun save() {
            }

            override fun print() {
                super.print()
            }
        }
    }

    /**
     * object
     *
     * kotlin没有静态属性和方法， 使用object创建单例对象
     */
    object User {
        const val userName = "admin"
        val password = "admin"
        fun hello() {
            print("hello")
        }
    }

    /**
     * 伴生对象
     *
     * 一个类只能有一个伴生对象
     */
    class DataProcessor {
        companion object DataProcess {
            fun process() {
                print("process")
            }
        }
    }

    /**
     * 数据类
     *
     * 1. 主构造函数至少包含一个参数
     * 2. 参数必须标识为val 或var
     * 3. 不能为abstract, open, sealed, inner
     * 4. 不能继承其他类, 但可以实现接口
     * 5. 解构声明用法
     *      var (name, age) = userData
     *      等同于 name = userData.component1() 等同于name = userData.name
     *      等同于 age = userData.component2() 等同于age = userData.age
     *
     * 6. Pair和Triple
     *
     */
    data class UserData(val name: String, var age: Int)


    /**
     * 内部类 分为 普通嵌套类， 内部嵌套类， 匿名嵌套类
     */
    class Outer {
        val one = 1
        // 普通嵌套类， 不持有外部类
        class Inner {
            val two = 2
            fun accessOuter() {
                // 报错， 普通嵌套类无法访问外部类
                // print("${one}")
            }
        }
        // 内部嵌套类, 持有外部类对象
        inner class Inner1 {
            val three = 3
            fun accessOuter() {
                print("$one")
            }
        }

        fun doRun() {
            Thread(object : Runnable { // 匿名内部类， 持有外部类对象
                override fun run() {
                    println(one)
                }
            }).start()

        }
    }
}