package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by yonney.yang on 2015/7/8.
 */
public class NIOServer {
    private Selector selector;

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        // 获得一个通道管理器
        this.selector = Selector.open();
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后
        //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    //采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
    public void listen() throws IOException {
        System.out.println("server listening");
        while (true) {
            //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector.select();
            Iterator iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //选中注册事件
                SelectionKey key = (SelectionKey) iterator.next();
                //删除已选的key,防止重复处理
                iterator.remove();
                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    // 获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.write(ByteBuffer.wrap(new String("send a msg").getBytes()));
                    //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                    channel.register(this.selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    /**
     * 处理读取客户端发来的信息的事件
     *
     * @param key
     * @throws java.io.IOException
     */
    public void read(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端收到信息：" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8080);
        server.listen();
    }
}
