package nestclass;

/**
 * Created by yonney.yang on 2015/8/21.
 */
public class StaticNestedClassTest {
    public static void main(String[] args) {

        //任何地方都可以创建
        StaticNestedClass.PublicNestedClass publicNestedClass = new StaticNestedClass.PublicNestedClass();

        //编译错误，无法访问内部内
        //StaticNestedClass.PrivateNestedClass privateNestedClass = new StaticNestedClass.PrivateNestedClass();
    }
}
