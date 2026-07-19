/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Info struct {
    node *TreeNode
    lvl int
}
func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    stack := make([]Info,0,100)
    stack = append(stack, Info{root,1})
    m := 0
    for len(stack) > 0 {
        cur := stack[len(stack)-1]
        stack = stack[:len(stack)-1]
        m = max(m, cur.lvl)
        if cur.node.Left != nil {
            stack = append(stack, Info{cur.node.Left, cur.lvl+1})
        }
        if cur.node.Right != nil {
            stack = append(stack, Info{cur.node.Right, cur.lvl+1})
        }
    }
    return m
}
