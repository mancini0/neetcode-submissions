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

 private String traverse(TreeNode root){
    Deque<TreeNode> s = new ArrayDeque<>();
    s.push(root);
    StringBuilder sb = new StringBuilder();
    while(!s.isEmpty()){
        var node = s.pop();
        sb.append(""+node.val);
        if(node.left != null){
            s.push(node.left);
        } else {
            sb.append("l");
        }
        if(node.right != null){
            s.push(node.right);
        }else{
            sb.append("r");
        }
    }
    return sb.toString();
 }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null && q==null) return true;
        if (q==null || p==null) return false;
        return traverse(p).equals(traverse(q));
    }
}
