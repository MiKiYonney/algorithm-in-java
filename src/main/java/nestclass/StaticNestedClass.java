package nestclass;

public class StaticNestedClass {
    private int i = 0;
    public static int j = 0;
    private final int k = 0;
    private static final int m = 0;
 
    // 静态嵌套内，这里不是innerclass,可以直接new出来
    public static class PublicNestedClass {
        private void test1() {
            // System.out.println(i); 非innerClass不能访问enclosing类的非static属性
            System.out.println(j);
            System.out.println(m);
            // System.out.println(k); 非innerClass不能访问enclosing类的非static属性
        }
        // 可以定义static方法
        private static void test2() {
 
        }
    }
 
    // 静态嵌套内，这里不是innerclass,由于是私有的，不可以直接new出来
    private static class PrivateNestedClass {
    }

    public static void main(String[] args) {
        //任何地方都可以创建
        StaticNestedClass.PublicNestedClass publicNestedClass = new StaticNestedClass.PublicNestedClass();

        //编译错误，无法访问内部内
        StaticNestedClass.PrivateNestedClass privateNestedClass = new StaticNestedClass.PrivateNestedClass();
    }
}