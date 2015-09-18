package tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yonney on 2015/9/18.
 */
public class TreeNodeVisit {
    //先序遍历-递归
    public static void preOrderTraverseRecursion(Node<Integer> root) {
        if (root == null) return;
        System.out.println(root.getValue());
        if (root.getLeft() != null) {
            preOrderTraverseRecursion(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrderTraverseRecursion(root.getRight());
        }
    }

    //先序遍历-非递归
    public void preOrderNoRecursion(Node<Integer> root) {
        LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
        stack.push(root);
        Node<Integer> current = null;
        while (!stack.isEmpty()){

        }
    }

    //中序遍历-递归
    public static void inOrderTraverseRecursion(Node<Integer> root) {
        if (root == null) return;
        if (root.getLeft() != null) {
            inOrderTraverseRecursion(root.getLeft());
        }
        System.out.println(root.getValue());
        if (root.getRight() != null) {
            inOrderTraverseRecursion(root.getRight());
        }
    }

    //中序非递归
    public static void inOrderNoRecursion(Node<Integer> root) {

    }


    //后序遍历-递归
    public static void afterOrderTraverseRecursion(Node<Integer> root) {
        if (root == null) return;
        if (root.getLeft() != null) {
            afterOrderTraverseRecursion(root.getLeft());
        }
        if (root.getRight() != null) {
            afterOrderTraverseRecursion(root.getRight());
        }
        System.out.println(root.getValue());
    }
}
