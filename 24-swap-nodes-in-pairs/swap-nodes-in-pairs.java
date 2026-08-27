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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode left = head;
        ListNode right;
        ListNode prevleft=null;
        ListNode res=null;
        int size = 2;
        while(true){
            right = left;
            for(int i=0;i<size-1;i++){
                if(right == null){
                    break;
                }
                else{
                    right = right.next;
                }
                
            }
            int times = size;
            if(right!= null){
                ListNode nextleft = right.next;
                ListNode curr = left;
                ListNode prev = null;
                while(times>0){
                    
                    ListNode way = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr  = way;
                    times--;

                }
                if(prevleft!=null){
                    prevleft.next = right;
                }
                prevleft = left;
                if(res == null){
                    res = right;
                }
                left = nextleft;


            }
            else{
                if(prevleft!=null){
                    prevleft.next = left;
                }
                if(res == null){
                    res = left;
                }
                break;
            }

        }
        return res;
       

        
    }
}