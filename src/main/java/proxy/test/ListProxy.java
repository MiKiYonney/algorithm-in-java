package proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yonney.yang on 2015/8/18.
 */
public class ListProxy<T> implements InvocationHandler {
    private List<T> target;

    public ListProxy(List<T> target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retVal ;
        System.out.println("[" + method.getName() + ": " + args[0] + "]");
        retVal = method.invoke(target, args);
        System.out.println("[size=" + target.size() + "]");
        return retVal;
    }
}
