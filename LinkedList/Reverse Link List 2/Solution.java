/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    public ListNode getNode(ListNode A, int len)
    {
        ListNode temp = A;
        while(len > 1)
        {
            temp = temp.next;
            len--;
        }
        return temp;
    }
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(B == C) // We don't have to reverse 
        {
            return A;
        }
        // We will solve this using a dummy node 
        ListNode dummy = new ListNode(-1);
        dummy.next = A;
        ListNode preStart = getNode(dummy,B);
        ListNode start = preStart.next;
        ListNode end = getNode(A,C);
        ListNode prev = end.next, curr = start;
        while(prev != end)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        preStart.next = end;
        return dummy.next;



    }
}
