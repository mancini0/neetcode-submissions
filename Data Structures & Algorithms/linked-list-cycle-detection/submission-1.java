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
    public boolean hasCycle(ListNode head) {
        if(head ==null) return false;
        Set<Integer> visited = new HashSet<>();
        ListNode cur = head;
        visited.add(cur.hashCode());
        while(cur.next != null){
            if(visited.contains(cur.next.hashCode())) return true; 
            visited.add(cur.next.hashCode());
            cur = cur.next;
        }
        return false;
    }
}
