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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> s = new ArrayDeque<>();
        s.add(root);
        while(!s.isEmpty()){
            var n = s.pop();
            var temp = n.left;
            n.left = n.right;
            n.right = temp;
            if(n.left!=null) s.push(n.left);
            if(n.right!=null) s.push(n.right);
        }
        return root;
    }
}
