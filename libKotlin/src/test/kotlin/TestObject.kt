import com.zjj.libkotlin.EnumClass
import com.zjj.libkotlin.MyClassAndConstructor
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 *
 *
 * @author zhangjiajun
 * @since 2024/3/28
 */
@RunWith(JUnit4::class)
class TestObject {
    @Test
    fun testConstructor() {
        var person = MyClassAndConstructor.Person2()
        person.age = 12
        person.name = "balabala"
    }
    @Test
    fun testAbstractObject() {
        var r = MyClassAndConstructor.Round(4.0, 4.0)
        println("area: ${r.area()}")
        r.onClick()
    }

    @Test
    fun testObject() {
        print(MyClassAndConstructor.User.userName)
        MyClassAndConstructor.User.hello()

        MyClassAndConstructor.DataProcessor.DataProcess.process()
    }

    @Test
    fun testDataClass() {
        val data = MyClassAndConstructor.UserData("abc", 13)
//        data.name = "123"
        var (name, age) = data
        name = "345"
        println("name: $name, age: $age")

    }

    @Test
    fun testPair() {
        var a = 1 to "T"
        var b = Triple("1","2","3")
        println("a: $a, b: $b")
    }

    @Test
    fun testEnum() {
        print("name: ${EnumClass.Direction.SOUTH.name}, ordinal: ${EnumClass.Direction.SOUTH.ordinal}")
        println("green: ${EnumClass.Color.GREEN.rgb}")
    }

    @Test
    fun testInnerClass () {
        var inClass = MyClassAndConstructor.Outer.Inner()
        var innerClass = MyClassAndConstructor.Outer().Inner1()
    }

}