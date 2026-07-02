/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func removeNthFromEnd(head *ListNode, n int) *ListNode {
    if head == nil {
		return head
	}
	length:=0
	cur := head
	for cur!=nil{
		 length++
		 cur = cur.Next 
	}
	if length==n{
		return head.Next
	}
	cur = head
	
	idx := -1
	for cur!=nil{
		idx++
		if idx == length-n-1 {
			cur.Next = cur.Next.Next
		}
		cur = cur.Next
	}
	return head
	
}
