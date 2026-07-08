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
    public int diameterOfBinaryTree(TreeNode root) {
        var maxDepth = 0;
        if(root == null) return maxDepth;
        Map<TreeNode,Integer> nodeDepth = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            var top = stack.peek();
            if(top.left != null && !nodeDepth.containsKey(top.left)){
                stack.push(top.left);
            } else if (top.right != null && !nodeDepth.containsKey(top.right)){
                stack.push(top.right);
            } else {
                top = stack.pop();
                var lDepth = nodeDepth.getOrDefault(top.left,0);
                var rDepth = nodeDepth.getOrDefault(top.right,0);
                nodeDepth.put(top,1+Math.max(lDepth,rDepth));
                maxDepth = Math.max(maxDepth, lDepth+rDepth);
            }
        }
        return maxDepth;
    }
}
