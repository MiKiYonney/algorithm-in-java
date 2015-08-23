package proxy;

/**
 * Created by yonney on 2015/8/12.
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = DynProxyFactory.getInstance();
        proxy.dealTask("abc");
    }
}
