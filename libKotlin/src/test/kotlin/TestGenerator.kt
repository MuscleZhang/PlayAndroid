import com.zjj.libkotlin.Genericity
import com.zjj.libkotlin.Genericity.GeneratorInterface
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TestGenerator {
    @Test
    fun testGeneratorImpl() {
        var gen1 = object : GeneratorInterface<String> {
            override fun next(): String {
                return "next: $this"
            }

        }
        println(gen1.next())
    }
    @Test
    fun testGenClass() {
        var cls = Genericity.GenClass<String, Int>()
        println(cls.toString("string",2))
    }

    @Test
    fun testGenMethod() {
        Genericity().genMethod(1, "string")
    }
}