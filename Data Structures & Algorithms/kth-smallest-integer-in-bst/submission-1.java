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
    public int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		var cur = root;
		while( cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			var n = stack.pop();
			if(--k==0) return n.val;
			cur = n.right;
		}
		return -1;
    }
}
