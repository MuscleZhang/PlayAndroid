package com.zjj.libkotlin


/**
 * 函数 方法
 *
 * @author zhangjiajun
 * @since 2024/5/16
 */
class Functions {
    /**
     * 声明函数
     *
     */
    // 声明一个函数类型的变量
    var sum = fun(a: Int, b: Int): Int {
        return a + b
    }

    // 正常声明函数
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * lambda 表达式
     */
    fun runLambda() {
        // 写法1 正常传入函数写法
        Thread(object : Runnable {
            override fun run() {
                print("1")
            }
        }).start()
        // 写法2， 转换成lambda表达式

        Thread({ print("2") }).start()

        // 写法3， 删除（）
        Thread { print("3") }.start()
    }

    /**
     * 高阶函数
     */
    /*
    run() 参数中的方法一定会执行一次
    并将lambda表达式的值作为run()方法返回值
     */
    fun doRun() {
        return "abc".run { print("run") }
    }

    /*
        apply() 参数中的方法一定会执行一次
        并将当前对象作为apply()方法返回值
     */
    fun doApply(): String {
        return "abc".apply { println("apply") }
    }

    /*
        let() 参数中的方法一定会执行一次， 并且会将当前对象作为参数传到方法中
        并将lambda表达式的值作为let()方法返回值
     */
    fun doLet(): Unit {
        return "abc".let {
            println("bcd")
//            return "bce"
        }
    }
    /*
        also() 参数中的方法一定会执行一次， 并且会将当前对象作为参数传到方法中
        并将当前对象作为also()方法返回值
     */
    fun doAlso(): String {
        return "also1".also {
            println("also in")
            return "alsoreturn"
        }
    }

    /*
        with() 参数中的方法一定会执行一次， 并将传入的receiver 作为调用lambda表示的对象
        并将其结果作为with() 的返回值
     */
    fun doWith(): String {
        return with("withParam") {
            return "withReturn"
        }
    }

    /**
     * 扩展函数, 扩展属性
     * ex:
     *  java中获取String的第一个字符， 因为String无法覆盖重写， 需要提供一个StringUtils来实现
     *  kotlin中使用扩展函数可以实现， 如"abc".getFirstChar()
     *
     *  原理:
     *  本质是使用了static 静态导入的方式
     *
     *  注：
     *  1. 如果需要在定义扩展函数的其他包下使用 扩展函数， 则需要import扩展函数
     */
    fun String.getFirstChar() : String {
        if (this.isEmpty()) {
            return ""
        }
        return this[0].toString()
    }
    /*
        实现List的扩展函数， 进行筛选数据
     */
    fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
        var list = ArrayList<T>()
        this.forEach {
            if (predicate(it)) {
                list.add(it)
            }
        }
        return list
    }

    /*
        扩展属性
     */
    var <T> ArrayList<T>.firstElement: T
        get() {
            return this[0]
        }
        set(value) {
            this[0] = value
        }


}