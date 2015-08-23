package proxy.test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonney.yang on 2015/8/18.
 */
public class ProxyTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        Class<?> clazz = list.getClass();
        ListProxy<String> proxy = new ListProxy<String>(list);

        List<String> stringList = (List<String>) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),proxy);
        stringList.add("a");
        stringList.add("b");

    }
}
