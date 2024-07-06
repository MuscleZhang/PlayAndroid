package com.zjj.libkotlin

/**
 * 泛型
 *
 * @author zhangjiajun
 * @since 2024/7/6
 */
class Genericity {
    /**
     * 泛型设计初衷
     *
     * 如果没有泛型， 在操作集合时
     * 1. 元素存储只能使用object, 在每次get时进行强转, 容易出问题
     * 2. String类型的集合，在存入其他类型的时候也不会报错, 容易出问题
     */

    /**
     * 泛型接口
     *
     * operator 操作符重载, 只能支持特定的方法, 如 +（plus）, - (minus)
     */
    interface GeneratorInterface <T> {
        fun next() : T
        fun defNext() {

        }

    }

    /**
     * 泛型类
     */

    class GenClass <K, V> {
        fun toString(k:K, v: V): String {
            return "k: $k, v: $v"
        }
    }

    /**
     * 泛型方法
     */
    public fun <E,R> genMethod(e:E, r: R): R {
        return r
    }

    /**
     * 类型上界
     *
     * Comparable是T的上界, 说明T都要实现Comparable接口才可以， 否则无法编译通过
     */

    fun <T : Comparable<T>> gt(x: T, y: T): Boolean {
        return true
    } //T的类型上界是Comparable<T>


    open class Food
    open class Fruit: Food()
    class Apple: Fruit()
    class Banana: Fruit()

    /**
     * 协变与逆变
     *
     * A 继承 B （A是B的子类）
     *
     * 如果f(A) 继承 f(B), 称为协变
     * 如果f(B) 继承 f(A), 称为逆变
     *
     * java中数组是协变的, 测试代码见testlib
     * Integer 是 Number的子类, 所以Integer[] 是 Number[]的子类, Integer[]变量可以赋值给 Number[]
     *
     * 泛型是非协变的, 测试代码见testlib
     * List<Integer>不是 List<Number>的子类, 没办法进行赋值操作
     * 但是List<Integer> 是 List<? extends Number>的子类， 可以进行赋值操作
     *
     * List<? extends T> 只能向其中添加T类型的元素, 不能添加T的子类型的元素
     * List<T> 可以添加T的子类型
     *
     * 逆变
     * List<? super Number> 是 List<Object> 的子类型， 可以进行赋值
     * List<? super Number> 能存Number的子类（Integer等）
     *
     * PESC
     * 现在问题来了：我们什么时候用extends，什么时候用super呢？
     * Effective Java给出了答案：PECS（Producer-Extends,Consumer-Super）。
     *
     * kotlin中 使用in T 表示消费者 相当于 ? super T  消费吞进了肚子里
     * 只能保证写入数据安全时类型安全的对象叫做消费者
     * 使用 out T 表示生产者 相当于 ? extends T 生产出对象
     * 只能保证读取数据安全时类型安全的对象叫做生产者
     * 提醒: List<? extends T>（上界）中只能存在T及其父类, List<? super T>（下界）中只能存储T及其子类
     */
    object GenFruitDemo {
        fun addFruit(list: MutableList<Fruit>) {

        }
        fun getFruit(list: MutableList<Fruit>) {

        }
    }

    fun genTransform() {
        var list : MutableList<Fruit> = mutableListOf(Fruit(),Fruit())
        var list2 : MutableList<Fruit> = mutableListOf(Apple(),Apple())
        var list3 : MutableList<Apple> = mutableListOf(Apple(),Apple())
        GenFruitDemo.addFruit(list)
//        GenFruitDemo.addFruit(list3) // error

    }

    /**
     * 类型擦除
     *
     * 过程
     * 1. 编译过程中找到需要替换的类型参数的具体类型， 通常是Object类， 如果设置了上界（? extends T）， 则具体类型为T
     * 2. 把代码中的所有类型参数都替换成具体的类，去掉类型声明，即<>的内容
     * 3. 自动生成一些方法， 由于擦除类型之后，类可能缺少某些必要方法， 此时会由编译器自动生成补充
     */

}