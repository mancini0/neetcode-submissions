/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Entry struct {
	node *TreeNode
	top int
}

func goodNodes(root *TreeNode) int {
    if root == nil {
		return 0
	}
	ans := 0
	q := make([]Entry,0,100)
	q = append(q, Entry{root,-101})
	for len(q) > 0 {
		cur := q[len(q)-1]
		q = q[:len(q)-1]
		if cur.node.Val >= cur.top {
			ans++
			cur.top = cur.node.Val
		}

		if cur.node.Left != nil {
			q = append(q, Entry{cur.node.Left,cur.top})
		}
		
		if cur.node.Right != nil {
			q = append(q, Entry{cur.node.Right,cur.top})
		}
	}
	return ans
}
