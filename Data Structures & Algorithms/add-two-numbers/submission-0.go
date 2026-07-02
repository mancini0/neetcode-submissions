/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	remainder := 0
	c1 := l1
	c2 := l2
	
	var head *ListNode;
	var prev *ListNode;

	for c1!= nil || c2 !=nil{
		l,r := 0,0
		if c1!=nil{
			l=c1.Val
			c1 = c1.Next
		}
		if c2!=nil{
			r=c2.Val
			c2=c2.Next
		}

		sum := l + r + remainder
		if sum > 9 {
			sum = sum-10
			remainder =1
		} else {
			remainder =0
		}
		this := &ListNode{Val: sum}
		if head == nil {
			head = this
			
		} else  {
			prev.Next = this
		}
		prev = this
	}
	if remainder ==1 {
		prev.Next = &ListNode{Val: 1}
	}
	return head
}
  
