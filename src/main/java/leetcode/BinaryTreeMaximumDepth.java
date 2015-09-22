package leetcode;

/**
 * Created by yonney.yang on 2015/3/30.
 */
public class BinaryTreeMaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
