package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by yonney.yang on 2015/7/9.
 */
public class NIOClient {
    private Selector selector;

    public void initClient(String ip,int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        this.selector = Selector.open();

        socketChannel.connect(new InetSocketAddress(ip, port));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void listen() throws IOException {
        while (true){
            selector.select();
            Iterator iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                if(key.isConnectable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    channel.write(ByteBuffer.wrap(new String("send a msg to server").getBytes()));
                    channel.register(this.selector, SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    read(key);
                }
            }
        }
    }

    public void read(SelectionKey key) throws IOException{
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("客户端收到信息："+msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    public static void main(String[] args) throws IOException {
        NIOClient client = new NIOClient();
        client.initClient("localhost",8080);
        client.listen();
    }
}
