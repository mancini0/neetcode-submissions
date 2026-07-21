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
    ceil *int
    floor *int
}

func isValidBST(root *TreeNode) bool {
    if root == nil {
        return true
    }
    q := make([]Entry, 0, 1000)
    q = append(q, Entry{root,nil,nil})
    for len(q) > 0 {
        cur := q[len(q)-1]
        q = q[:len(q)-1] 
        if cur.node.Left != nil {
            //universal check applicable to all cases
            if cur.node.Val <= cur.node.Left.Val {
                return false
            }
            if cur.ceil == nil && cur.floor == nil {
                q = append(q, Entry{cur.node.Left, &cur.node.Val,nil})

            } else if cur.ceil != nil && cur.floor == nil {             
                if cur.node.Left.Val >= *cur.ceil {
                    return false
                }
                q = append(q, Entry{cur.node.Left, &cur.node.Val,nil})
                
            } else if cur.ceil == nil && cur.floor != nil {
                if cur.node.Left.Val <= *cur.floor {
                    return false
                }
                q = append(q, Entry{cur.node.Left, &cur.node.Val, cur.floor})
            } else {
                if cur.node.Left.Val >= *cur.ceil || cur.node.Left.Val <= *cur.floor {
                    return false
                }
                q = append(q, Entry{cur.node.Left, &cur.node.Val, cur.floor})
            }
        } // Closed cur.node.Left check
        if cur.node.Right != nil {
            //universal check applicable to all cases
            if cur.node.Val >= cur.node.Right.Val {
                return false
            }
            if cur.ceil == nil && cur.floor == nil {
                q = append(q, Entry{cur.node.Right, nil, &cur.node.Val})

            } else if cur.ceil != nil && cur.floor == nil {             
                if cur.node.Right.Val >= *cur.ceil {
                    return false
                }
                q = append(q, Entry{cur.node.Right, cur.ceil, &cur.node.Val})
                
            } else if cur.ceil == nil && cur.floor != nil {
                if cur.node.Right.Val <= *cur.floor {
                    return false
                }
                q = append(q, Entry{cur.node.Right, nil, &cur.node.Val})
            } else {
                if cur.node.Right.Val >= *cur.ceil || cur.node.Right.Val <= *cur.floor {
                    return false
                }
                q = append(q, Entry{cur.node.Right, cur.ceil, &cur.node.Val})
            }
        } // Closed cur.node.Right check
    } // Closed for loop
    return true    
}