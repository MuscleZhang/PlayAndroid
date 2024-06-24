import com.zjj.libkotlin.Functions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 *
 *
 * @author zhangjiajun
 * @since 2024/5/16
 */
@RunWith(JUnit4::class)
class TestFunction {
    @Test
    fun testShengming() {
        println(Functions().sum(1, 2))
        println(Functions().add(1, 3))
    }

    @Test
    fun testFuncs() {
        println(" run:  ${Functions().doRun()}")
        println(" apply:  ${Functions().doApply()}")
        println("let: ${Functions().doLet()}")
        println(" also: ${Functions().doAlso()}")
    }

    @Test
    fun testExtendFun() {
        var list = listOf("a1","a2","a3","b4","a5","b6")
        var result = list.filter {
            it.startsWith("a")
        }
        println(result.toString())
    }
}