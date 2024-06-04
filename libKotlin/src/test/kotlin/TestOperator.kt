import com.zjj.libkotlin.Operation
import com.zjj.libkotlin.Operation.grow
import com.zjj.libkotlin.Operation.plus
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 *
 *
 * @author zhangjiajun
 * @since 2024/3/21
 */
@RunWith(JUnit4::class)
class TestOperator {
    @Test
    fun testUnaryMinus() {
        Operation.pointUnaryMinus()
    }
    @Test
    fun testPlus() {
        // 12
        println("" + 1 + 2)
    }

    @Test
    fun testCustomPlus() {
        val count = Operation.Counter(10)
        println(count + 2)
    }

    @Test
    fun testIn() {
        println(2 in 1..4)
    }

    @Test
    fun testInfix() {
        val person = Operation.Person("Dominic", 30)
        // 使用函数调用方式
        println(person.grow(3))
        // 使用中缀表达式方式
        println(person grow 3)
    }
}