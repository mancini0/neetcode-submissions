/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func mergeKLists(lists []*ListNode) *ListNode {
    var d ListNode
	cur := &d
	m := make(map[int]*ListNode)
	for i,l := range lists {
		if l == nil {
			continue
		}
		m[i] = l	
	}
	for len(m)>0 {
		minLoop := 1001
		contributor := -1
		for i, v := range m {
			if v.Val <= minLoop {
				minLoop = v.Val
				contributor = i
			}
			
		}
		cur.Next = m[contributor]
		cur = cur.Next
		m[contributor] = m[contributor].Next
		if m[contributor] == nil {
				delete(m,contributor)
		}
	}
	return d.Next
}
