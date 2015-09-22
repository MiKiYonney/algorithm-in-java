package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yonney on 2015/9/22.
 */
public class InvertBinaryTree {
    /**
     * 1、交换根节点的左右子树。
     * 2、对左右子树分别执行递归反转 。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }


    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new InvertBinaryTree().invertTree1(root);
    }

}
