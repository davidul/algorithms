package davidul.problems.leetcode.solved.easy;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthBinaryTree104 {

    public static void main(String[] args) {
        final MaximumDepthBinaryTree104 maximumDepthBinaryTree104 = new MaximumDepthBinaryTree104();
        System.out.println(maximumDepthBinaryTree104.dfs(null));
        System.out.println(maximumDepthBinaryTree104.dfs(new TreeNode(1)));
        System.out.println(maximumDepthBinaryTree104.dfs(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(maximumDepthBinaryTree104.dfs(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
    }

    private Integer dfs(TreeNode n) {
        if(n == null)
            return 0;
        return Math.max(dfs(n.left), dfs(n.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
