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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Map<TreeNode,Integer> depth = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            var cur = stack.peek();
            if (cur.left!=null && !depth.containsKey(cur.left)){
                stack.push(cur.left);
            } else if(cur.right!=null && !depth.containsKey(cur.right)){
                stack.push(cur.right);
            } else {
                var popped = stack.pop();
                int l = 0;
                int r = 0;
                if(popped.left != null){
                    l = depth.getOrDefault(popped.left,l);
                }
                if(popped.right != null){
                    r = depth.getOrDefault(popped.right,r);
                }
                if(Math.abs(r-l) > 1) return false;
                depth.put(popped, Math.max(r,l)+1);
            }
        }
        return true; // or check deltas explicitly?
    }
}
