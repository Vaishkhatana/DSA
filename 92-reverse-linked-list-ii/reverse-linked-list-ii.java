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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode before = null;
        int pos = 1;
        ListNode t = head;
        while(pos<left){
            before =t;
            t= t.next;
            pos++;
            continue;
        }
        
        int times = right-left+1;
        ListNode curr = t;
        ListNode prev = null;
        while(times>0){
            ListNode way  = curr.next;
            curr.next = prev;
            prev  =curr;
            curr = way;
            times--;
        }
        t.next = curr;
        if(before == null){
            return prev;
        }


        before.next = prev;
        return head; 


        

        
        
        
    }
}