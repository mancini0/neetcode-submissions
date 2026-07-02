/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func removeNthFromEnd(head *ListNode, n int) *ListNode {
    if head == nil {
		return nil
	}

	cur := head
	l := 0
	for cur != nil {
		l++
		cur = cur.Next
	}
	if l==n {
		return head.Next
	}
	cur = head
	dummy := &ListNode{Next:cur}
	idx:=-1
	for cur != nil {
		idx++
		if idx == l-n-1{
			cur.Next = cur.Next.Next
		}
		cur = cur.Next
	}
	return dummy.Next
}
