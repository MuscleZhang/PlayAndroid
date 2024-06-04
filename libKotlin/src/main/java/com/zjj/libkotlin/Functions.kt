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
    var sum = fun(a:Int, b: Int): Int {
        return a + b
    }

    // 正常声明函数
    fun add(a:Int, b:Int):Int {
        return a + b
    }

    /**
     * lambda 表达式
     */
    fun runLambda() {
        // 写法1 正常传入函数写法
        Thread(object :Runnable{
            override fun run() {
                print("1")
            }
        }).start()
        // 写法2， 转换成lambda表达式

        Thread( { print("2") }).start()

        // 写法3， 删除（）
        Thread { print("3") }.start()
    }

    /**
     * 高阶函数
     */
    /*
    run() 参数中的方法一定会执行一次
     */
    fun doRun() {
        return "abc".run { print("run") }
    }

    /*
        apply() 参数中的方法一定会执行一次， 并且会将返回当前对象返回
     */
    fun doApply(): String {
        return "abc".apply { println("apply") }
    }

    /*
        let() 参数中的方法一定会执行一次， 并且会将当前对象作为参数传到方法中
     */


}