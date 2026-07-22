/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */




func kthSmallest(root *TreeNode, k int) int {
	var stack []*TreeNode
	var ans []int
	cur := root
	for len(stack) > 0 || cur != nil {
		for cur != nil {
			stack = append(stack, cur)
			cur = cur.Left
		}
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		ans = append(ans,node.Val)
		cur = node.Right
	}
	return ans[k-1]
}
