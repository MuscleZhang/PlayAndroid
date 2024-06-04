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
        print(" run:  ${Functions().doRun()}")
        print(" apply:  ${Functions().doApply()}")
    }
}