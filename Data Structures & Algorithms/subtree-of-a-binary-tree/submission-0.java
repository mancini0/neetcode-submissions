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

    public boolean search(TreeNode root, TreeNode subRoot){
        Deque<TreeNode> rStack = new ArrayDeque<>();
        Deque<TreeNode> lStack = new ArrayDeque<>();
        rStack.push(root);
        lStack.push(subRoot);

        while(!lStack.isEmpty()){
            if(rStack.isEmpty()){
                return false;
            }
         var l = lStack.pop();
         var r = rStack.pop();
         if(l.val != r.val){
            return false;
         }
         if(l.left !=null && r.left!=null){
            lStack.push(l.left);
            rStack.push(r.left);
         }else if (l.left !=null && r.left==null){
            return false;
         }else if (l.left == null && r.left!=null){
            return false;
         }
         if(l.right !=null && r.right!=null){
            lStack.push(l.right);
            rStack.push(r.right);
         }else if (l.right !=null && r.right==null){
            return false;
         }
         else if (l.right == null && r.right!=null){
            return false;
         }
        }
        return true;
    }
     
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode copy = subRoot;
        var signal = subRoot.val;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            var node = stack.pop();
            if(node.val == signal){
                if(search(node,subRoot)){
                    return true;
                }
            }
            if(node.left !=null) stack.push(node.left);
            if(node.right !=null) stack.push(node.right);
        }
        return false;
    }
}
