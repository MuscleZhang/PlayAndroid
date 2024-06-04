import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * 类型测试类
 *
 * @author zhangjiajun
 * @since 2024/3/22
 */
@RunWith(JUnit4::class)
class TestType {
    /**
     * 装箱和拆箱
     * Int 对标 int(java)
     * Int? 对标 Integer(java)
     */
    @Test
    fun testWrapper() {
        val a: Int = 1000
        val b: Int = 1000

        val c: Int? = 1000
        val d: Int? = 1000
        println("$a $c")
        println("${a === b}, ${c===d}")
    }
}