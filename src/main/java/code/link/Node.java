package code.link;

/**
 * Created by yonney.yang on 2015/8/24.
 */
public class Node {
    private int data;
    private Node next;

    public Node(){

    }

    public Node(int data) {
        this.data = data;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(int data,Node next) {
        this.next = next;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
