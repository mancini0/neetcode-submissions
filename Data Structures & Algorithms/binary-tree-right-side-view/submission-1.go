/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func rightSideView(root *TreeNode) []int {
	if root == nil {
		return nil
	}
    ans := make([]int, 0, 100)
	q := make([]*TreeNode,0,100)
	q = append(q, root)
	for len(q) > 0 {
		sz := len(q)
		for i:=0; i<sz; i++ {
			cur := q[0]
			q[0] = nil
			q = q[1:]
			if cur.Left != nil {
				q = append(q, cur.Left)
			}
			if cur.Right != nil {
				q = append(q, cur.Right)
			}
			if i==sz-1{
				ans = append(ans,cur.Val)
			}
		}
	}
	return ans
}
