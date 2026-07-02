/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */


func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	
	oldToNew :=make(map[*Node]*Node)
	cur := head
	
	for cur != nil {
		a := &Node{Val: cur.Val}
		oldToNew[cur]=a
		cur = cur.Next
	}
	cur = head
	
	for cur != nil {
		n := oldToNew[cur]
		n.Next = oldToNew[cur.Next]
		n.Random = oldToNew[cur.Random]
		cur = cur.Next
	}
	return oldToNew[head]
}
