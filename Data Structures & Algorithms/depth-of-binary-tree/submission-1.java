/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        int max =0;
        if(root == null) return max;
        Deque<Object[]> stack = new ArrayDeque<Object[]>();
        stack.push(new Object[]{root,max+1});
        while(!stack.isEmpty()){
            var popped = stack.pop();
            var node = (TreeNode) popped[0];
            var lvl = (int) popped[1];
            max = Math.max(max,lvl);
            if(node.left != null) stack.push(new Object[]{node.left, lvl+1});
            if(node.right != null) stack.push(new Object[]{node.right, lvl+1});
        }
        return max;
    }
}
