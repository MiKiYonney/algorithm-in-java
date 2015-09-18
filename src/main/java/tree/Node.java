package tree;

/**
 * Created by yonney on 2015/9/18.
 */
public class Node<V> {
    private V value;
    private Node<V> left;
    private Node<V> right;

    public Node(){

    }

    public Node(V value, Node<V> left, Node<V> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getLeft() {
        return left;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public Node<V> getRight() {
        return right;
    }

    public void setRight(Node<V> right) {
        this.right = right;
    }
}
