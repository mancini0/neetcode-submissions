/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list2==null) return list1;
        if(list1==null) return list2;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode node1 = list1;
        ListNode node2 = list2;
        Queue<ListNode> q1  = new PriorityQueue<>((l1,l2)->Integer.compare(l1.val,l2.val));
        q1.add(list1);
        Queue<ListNode> q2  = new PriorityQueue<>((l1,l2)->Integer.compare(l1.val,l2.val));
        q2.add(list2);
        while(node1.next !=null){
            q1.add(node1.next);
            node1 = node1.next;
        }
        while(node2.next !=null){
            q2.add(node2.next);
            node2 = node2.next;
        }
        while(q1.size()>0 || q2.size()>0){
            Integer v1 = Optional.ofNullable(q1.peek()).map(ln->ln.val).orElse(null);
            Integer v2 = Optional.ofNullable(q2.peek()).map(ln->ln.val).orElse(null);
            if(v1==null){
                dummy.next = q2.poll();
            }
            else if (v2==null){
                dummy.next = q1.poll();
            }
            else if (v1<v2){
                dummy.next = q1.poll();
            }
            else if (v2<v1){
                dummy.next = q2.poll();
            }
            else {
                dummy.next = q2.poll();
            }
            dummy = dummy.next;
        
        }
        return ans.next;
    }
}