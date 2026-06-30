/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    dummy := &ListNode{-1,nil}
    ans := dummy
    cur1 := list1
    cur2 := list2
    for cur1!=nil || cur2 != nil {
        if cur1==nil{
            dummy.Next = cur2
            cur2 = cur2.Next
        }else if cur2==nil {
            dummy.Next = cur1
            cur1 = cur1.Next
        }else {
            if cur1.Val > cur2.Val {
                dummy.Next=cur2
                cur2=cur2.Next
            } else if cur1.Val <= cur2.Val {
                dummy.Next=cur1
                cur1 = cur1.Next
            }
         }
         dummy = dummy.Next;
    }
    return ans.Next
}
