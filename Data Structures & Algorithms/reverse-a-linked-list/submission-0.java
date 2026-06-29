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
    public ListNode reverseList(ListNode head) {
        if(head ==null) return head;
        ListNode node = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.push(node);
        while(node.next != null){
            stack.push(node.next);
            node=node.next;
        }
        boolean popped = false;
        ListNode ans = null;
        while(!stack.isEmpty()){
            ListNode n = stack.pop();
            if(!popped) ans = n;
            popped = true;
            n.next = stack.peek(); 
        }
        return ans;
    }
}
