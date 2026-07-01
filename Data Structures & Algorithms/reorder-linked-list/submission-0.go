/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reorderList(head *ListNode) {
    slow, fast := head, head
    //move slow to halfway point
    for fast!=nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
    }

    //cut list in half
    cur := slow.Next
    slow.Next = nil

    //reverse 2nd half
    var prev *ListNode
    for cur!= nil{
        next := cur.Next
        cur.Next = prev
        prev = cur
        cur = next
    }
    //1,2,3
    //4,nil
    //1,prev

    for head !=nil && prev!=nil {
        lNext := head.Next  
        rNext := prev.Next 
        head.Next = prev 
        head = lNext
        prev.Next=lNext
        prev = rNext
    }
    

}
