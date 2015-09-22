package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yonney.yang on 2015/9/2.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nodeValues = new ArrayList<Integer>();
        if(root == null) return result;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);

        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                result.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nodeValues = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            nodeValues.add(cur.val);

            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        result.add(nodeValues);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode _1 = new TreeNode(2);
        TreeNode _2 = new TreeNode(3);
        TreeNode _3 = new TreeNode(4);
        TreeNode _4 = new TreeNode(5);
        root.left = _1;
        root.right = _2;
        _2.left = _3;
        _2.right = _4;
        new BinaryTreeLevelOrderTraversal().levelOrder1(root);
    }
}
