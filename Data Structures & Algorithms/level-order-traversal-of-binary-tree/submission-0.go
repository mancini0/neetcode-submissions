/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
    var ans [][]int
	q := make([]*TreeNode,0,1000)
	q = append(q, root)
	for len(q) >0 {
		sz := len(q)
		row := make([]int,sz,sz);
		for i:=0; i<sz; i++ {
			cur := q[0]
			q = q[1:]
			row[i] = cur.Val
			if cur.Left != nil {
				q = append(q,cur.Left)
			}
			if cur.Right != nil {
				q = append(q, cur.Right)
			}
		}
		ans = append(ans, row)
	}
	return ans
}
