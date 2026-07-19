/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
        return root
    }
    s := make([]*TreeNode,0,100)
    s = append(s,root)
    for len(s) > 0 {
        cur := s[len(s)-1]
        s = s[0:len(s)-1]
        if cur.Left != nil {
            s = append(s, cur.Left)
        }
        if cur.Right != nil {
            s = append(s, cur.Right)
        }
        cur.Left, cur.Right = cur.Right, cur.Left
    }
    return root
}
