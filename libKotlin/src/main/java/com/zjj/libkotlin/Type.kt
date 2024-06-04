package com.zjj.libkotlin


/**
 * 类型
 *
 * @author zhangjiajun
 * @since 2024/3/22
 */
object Type {
    /**
     * 拆箱和装箱
     *      kotlin中非空数字类型Int到可空数字类型Int? 需要装箱
     *      Int? 会被编译器自动拆箱成Int
     */

    /**
     * 可空类型
     *
     *      安全调用符
     *      ?.
     *
     *      结合Elvis运算符
     *      s?.length ?: 0
     *
     *      null == null // 是true
     *      null 是Nothing? 类型
     *      null 不是Any类型， 但是是Any? 子类型
     */

    /**
     * Unit类型
     * 与Java中的void一样的功能
     *
     * Unit 是Any 子类型
     * Unit? 是 Any? 子类型
     * Any 是Any？ 子类型
     */

    // Unit类型大多数情况不需要显式
    // 方法的返回类型是kotlin.Unit
    // 写法1
    fun unitExample() {
        println("this is unit")
    }
    // 写法2
    fun unitExample1() {
        return Unit
    }
    // 写法3
    fun unitExample2() : Unit {}

    /**
     * Nothing
     *
     * kotlin最底层就是Nothing类型， 意味着Nothing是任何类型的子类型， 如Any， String，MyClass
     *
     * 如果函数返回值是Nothing，意味着这个函数永远不会有返回值
     *
     * 可以使用Nothing表达一个从来不存在的返回值， 如EmptyList中的get()函数
     *
     * Nothing? 可以只包含一个null值
     */

    // Nothing类定义如下
    // 外部无法创建Nothing对象
    public class Nothing private constructor()

    /**
     * Unit 和 Nothing的区别
     *
     * Unit：返回类型是Unit
     * Nothing: 永远不会返回， 与Java中的void相同
     */


    /**
     * Any 和Any?
     *
     * Any 是所有非空类型的父类
     * Any? 是可空类型的父类
     *
     * Any? 是Any的超类 是kotlin所有类型的父类
     */

    /**
     * as 类型转换运算符
     * 支持子类型转换成父类型
     *
     * 如果类型不兼容， 可以使用as?运算符返回null
     */
}