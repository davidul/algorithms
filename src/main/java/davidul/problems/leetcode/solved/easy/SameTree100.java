package davidul.problems.leetcode.solved.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * <p>
 * <p>
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public class SameTree100 {

    public static void main(String[] args) {
        final SameTree100 sameTree100 = new SameTree100();
        //p = [1,2,3], q = [1,2,3]
        final TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        final TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sameTree100.isSameTree(treeNode, treeNode1));
        System.out.println("");
        //p = [1,2], q = [1,null,2]
        final TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), null);
        final TreeNode treeNode3 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(sameTree100.isSameTree(treeNode2, treeNode3));
        System.out.println("");
        //p = [1,2,1], q = [1,1,2]
        final TreeNode treeNode4 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        final TreeNode treeNode5 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(sameTree100.isSameTree(treeNode4, treeNode5));

        System.out.println(sameTree100.isSameTree(new TreeNode(), new TreeNode()));
        System.out.println(sameTree100.isSameTree(null, new TreeNode()));

    }

    List<Integer> path = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        final List<Integer> dfs = new ArrayList<>(dfs(p));
       /* for (Integer i : dfs) {
            System.out.println(i + " ");
        }
        System.out.println("============");*/
        path.clear();
        final List<Integer> dfs1 = dfs(q);
        /*for (Integer i : dfs) {
            System.out.println(i + " ");
        }*/

        if (dfs.size() != dfs1.size()) {
            return false;
        }

        for (int i = 0; i < dfs.size(); i++) {
            final Integer integer = dfs.get(i) == null ? Integer.MIN_VALUE : dfs.get(i);
            final Integer integer1 = dfs1.get(i) == null ? Integer.MIN_VALUE : dfs1.get(i);
            if (!integer.equals(integer1)) {
                return false;
            }

        }
        path.clear();
        return true;
    }

    private List<Integer> dfs(TreeNode n) {
        if(n == null)
            return new ArrayList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        dfs(n, visited, path);
        return path;
    }

    private void dfs(TreeNode n, Map<TreeNode, Boolean> visited, List<Integer> path) {
        visited.put(n, true);
        path.add(n.val);
        if (n.left == null && n.right == null) {
            return;
        }

        if (n.left != null && !visited.containsKey(n.left)) {
            dfs(n.left, visited, path);
        } else {
            path.add(null);
        }

        if (n.right != null && !visited.containsKey(n.right)) {
            dfs(n.right, visited, path);
        } else {
            path.add(null);
        }
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

